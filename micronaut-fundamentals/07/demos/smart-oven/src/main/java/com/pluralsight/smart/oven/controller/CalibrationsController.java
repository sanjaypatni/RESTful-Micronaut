package com.pluralsight.smart.oven.controller;


import com.pluralsight.smart.oven.dto.calibration.CalibrationUpdateResult;
import com.pluralsight.smart.oven.service.CalibrationsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/calibrations")
public class CalibrationsController {

    private static final Logger logger
            = LoggerFactory.getLogger(CalibrationsController.class);

    private CalibrationsService calibrationsService;

    public CalibrationsController(CalibrationsService calibrationsService) {
        this.calibrationsService = calibrationsService;
    }

    @Get("/calibrate")
    public Flowable<CalibrationUpdateResult> calibrateOven() {
        return calibrationsService.calibrateOven();
    }

    @Get("/calibrate/declarative")
    public Single<CalibrationUpdateResult> calibrateOvenUsingDeclarativeClient() {
        return calibrationsService.calibrateOvenUsingDeclarativeClient();
    }
}
