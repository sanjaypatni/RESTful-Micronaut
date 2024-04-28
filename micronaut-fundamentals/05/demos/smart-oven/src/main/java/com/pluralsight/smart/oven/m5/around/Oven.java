package com.pluralsight.smart.oven.m5.around;

import io.micronaut.context.annotation.Context;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

//@Context
public class Oven {

    private Controls controls;

    @Inject
    public Oven(Controls controls) {
        this.controls = controls;
    }

    @PostConstruct
    public void postConstruct() {
        controls.setControls("10m", 600);
        controls.setControls("20m", 300);
    }
}
