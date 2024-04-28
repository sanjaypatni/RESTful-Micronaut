package com.pluralsight.smart.oven.m5.around;

import com.pluralsight.smart.oven.m5.around.aspect.Log;
import io.micronaut.context.annotation.Context;

@Context
public class Controls {

    private String duration;
    private Integer temp;

    @Log
    public void setControls(String duration, Integer temp) {
        this.duration = duration;
        this.temp = temp;
    }

}
