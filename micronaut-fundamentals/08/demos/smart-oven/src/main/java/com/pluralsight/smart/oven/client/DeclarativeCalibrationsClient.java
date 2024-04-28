package com.pluralsight.smart.oven.client;

import com.pluralsight.smart.oven.dto.calibration.CalibrationParameters;
import com.pluralsight.smart.oven.dto.calibration.CalibrationStatus;
import com.pluralsight.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Single;

@Client("http://localhost:8020")
public interface DeclarativeCalibrationsClient {

    @Get("/calibrations/{modelName}")
//    @Retryable(attempts = "3", delay = "2s")
//    @CircuitBreaker
    Single<CalibrationParameters> getCalibrationParameters(String modelName);

    @Put("/calibrations/updates")
    Single<CalibrationUpdateResult> updateCalibrationParameters(@Body CalibrationStatus calibrationStatus);

}
