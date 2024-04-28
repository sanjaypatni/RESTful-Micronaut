package com.pluralsight.smart.oven.m3.beans;

import javax.inject.Singleton;

@Singleton
public class Grill {

    public void turnOn() {
        System.out.println("Turning on the Grill");
    }
}
