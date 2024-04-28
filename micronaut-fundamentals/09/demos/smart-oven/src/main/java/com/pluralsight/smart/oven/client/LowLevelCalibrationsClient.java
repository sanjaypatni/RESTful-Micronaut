package com.pluralsight.smart.oven.client;

import com.pluralsight.smart.oven.dto.calibration.CalibrationParameters;
import com.pluralsight.smart.oven.dto.calibration.CalibrationStatus;
import com.pluralsight.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class LowLevelCalibrationsClient {

    private static final Logger logger
            = LoggerFactory.getLogger(LowLevelCalibrationsClient.class);

    private RxHttpClient client;

    public LowLevelCalibrationsClient(@Client("http://localhost:8020") RxHttpClient client) {
        this.client = client;
    }

    public Flowable<CalibrationParameters> getCalibrationParameters(String modelName) {
        logger.info("Calling GET calibration parameters using the low-level client for model {}", modelName);

        Flowable<CalibrationParameters> calibrationParameters =
                client.retrieve(HttpRequest.GET("/calibrations/" + modelName),
                        CalibrationParameters.class);
        return calibrationParameters;
    }

    public Flowable<CalibrationUpdateResult> updateCalibrationStatus(CalibrationStatus calibrationStatus) {
        logger.info("Calling PUT calibration updates using the low-level client with {}", calibrationStatus);

        return client.retrieve(HttpRequest.PUT("/calibrations/updates", calibrationStatus),
                CalibrationUpdateResult.class);
    }
}
