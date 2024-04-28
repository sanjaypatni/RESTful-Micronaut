package com.pluralsight.smart.oven.m3.scopes;

import javax.inject.Singleton;

@Singleton
public class Oven3 {

    private Lights lights;

    public Oven3(Lights lights) {
        System.out.println("Calling Oven3 constructor");
        this.lights = lights;
    }

    public void turnOn() {
        System.out.println("Turning on the Oven3");
    }
}
