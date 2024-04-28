package com.pluralsight.cloud.service.controller;

import com.pluralsight.cloud.service.dto.CalibrationParameters;
import com.pluralsight.cloud.service.dto.CalibrationStatus;
import com.pluralsight.cloud.service.dto.CalibrationUpdateResult;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/calibrations")
public class CalibrationsController {

    private static final Logger logger
            = LoggerFactory.getLogger(CalibrationsController.class);

    @Get("/{modelName}")
    public CalibrationParameters getCalibrationParameters(String modelName) {
        logger.info("getCalibrationParameters called for model {}", modelName);
        return new CalibrationParameters(modelName, 800, 150);
    }

    @Put("/updates")
    public CalibrationUpdateResult updateCalibrationStatus(@Body CalibrationStatus update) {
        logger.info("updateCalibrationResults called with {}", update);
        return new CalibrationUpdateResult(true);
    }

}
