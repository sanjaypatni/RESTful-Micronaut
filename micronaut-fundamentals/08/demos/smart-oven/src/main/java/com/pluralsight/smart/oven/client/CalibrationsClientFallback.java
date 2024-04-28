package com.pluralsight.smart.oven.client;

import com.pluralsight.smart.oven.dto.calibration.CalibrationParameters;
import com.pluralsight.smart.oven.dto.calibration.CalibrationStatus;
import com.pluralsight.smart.oven.dto.calibration.CalibrationUpdateResult;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;

@Fallback
public class CalibrationsClientFallback implements DeclarativeCalibrationsClient {

    @Override
    public Single<CalibrationParameters> getCalibrationParameters(String modelName) {
        return Single.just(new CalibrationParameters(modelName, 0, 0));
    }

    @Override
    public Single<CalibrationUpdateResult> updateCalibrationParameters(CalibrationStatus calibrationStatus) {
        return Single.just(new CalibrationUpdateResult(false));
    }
}
