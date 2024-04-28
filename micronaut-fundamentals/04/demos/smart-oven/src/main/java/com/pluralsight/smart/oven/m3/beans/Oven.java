package com.pluralsight.smart.oven.m3.beans;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Oven {

    @Inject
    private Lights lights;
    private Grill grill;

    public Oven() { }

    public void turnOn() {
        System.out.println("Turning on the Oven");
        lights.turnOn();
        grill.turnOn();
    }

    public Lights getLights() {
        return lights;
    }

    public void setLights(Lights lights) {
        this.lights = lights;
    }

    public Grill getGrill() {
        return grill;
    }

    public void setGrill(Grill grill) {
        this.grill = grill;
    }
}
