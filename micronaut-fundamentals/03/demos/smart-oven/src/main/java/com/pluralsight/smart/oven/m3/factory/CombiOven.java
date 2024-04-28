package com.pluralsight.smart.oven.m3.factory;

import javax.inject.Singleton;

@Singleton
public class CombiOven {

    private Microwave microwave;

    public CombiOven(Microwave microwave) {
        this.microwave = microwave;
    }

    public void turnOnMicrowave() {
        microwave.turnOn();
    }

    public void turnOnOven() {
        System.out.println("Turning on the Oven");
    }
}
