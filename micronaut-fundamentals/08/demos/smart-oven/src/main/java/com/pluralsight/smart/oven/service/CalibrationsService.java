package com.pluralsight.smart.oven.service;

import com.pluralsight.smart.oven.client.DeclarativeCalibrationsClient;
import com.pluralsight.smart.oven.client.LowLevelCalibrationsClient;
import com.pluralsight.smart.oven.dto.calibration.CalibrationStatus;
import com.pluralsight.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.time.LocalDateTime;

@Singleton
public class CalibrationsService {

    private static final Logger logger
            = LoggerFactory.getLogger(CalibrationsService.class);

    private static final String OVEN_MODEL = "PLURALSIGHT_OVEN";
    private static final String SERIAL_NO = "123456";

    private LowLevelCalibrationsClient lowLevelClient;
    private DeclarativeCalibrationsClient declarativeClient;

    public CalibrationsService(LowLevelCalibrationsClient lowLevelClient, DeclarativeCalibrationsClient declarativeClient) {
        this.lowLevelClient = lowLevelClient;
        this.declarativeClient = declarativeClient;
    }

    public Flowable<CalibrationUpdateResult> calibrateOven() {
        logger.info("Calibrating oven using low-level client ...");
        return lowLevelClient.getCalibrationParameters(OVEN_MODEL)
                .doOnNext(parameters -> logger.info("Calibrations parameters received {}", parameters))
                .doOnNext(parameters -> logger.info("Calibrating oven ..."))
                .doOnNext(parameters -> logger.info("Oven calibration complete! Sending updates to cloud ..."))
                .flatMap(parameters -> lowLevelClient.updateCalibrationStatus(new CalibrationStatus(OVEN_MODEL, SERIAL_NO, LocalDateTime.now())))
                .doOnNext(updateResult -> logger.info("Update result received {}", updateResult));
    }

    public Single<CalibrationUpdateResult> calibrateOvenUsingDeclarativeClient() {
        logger.info("Calibrating oven using declarative client ...");
        return declarativeClient.getCalibrationParameters(OVEN_MODEL)
                .doOnSuccess(parameters -> logger.info("Calibrations parameters received {}", parameters))
                .doOnSuccess(parameters -> logger.info("Calibrating oven ..."))
                .doOnSuccess(parameters -> logger.info("Oven calibration complete! Sending updates to cloud ..."))
                .flatMap(parameters -> declarativeClient.updateCalibrationParameters(new CalibrationStatus(OVEN_MODEL, SERIAL_NO, LocalDateTime.now())))
                .doOnSuccess(updateResult -> logger.info("Update result received {}", updateResult));
    }
}
