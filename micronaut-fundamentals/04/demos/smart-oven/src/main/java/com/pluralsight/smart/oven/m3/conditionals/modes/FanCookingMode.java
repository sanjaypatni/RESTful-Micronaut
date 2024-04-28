package com.pluralsight.smart.oven.m3.conditionals.modes;

import javax.inject.Singleton;

@Singleton
public class FanCookingMode implements CookingMode {
    @Override
    public void setCookingMode() {
        System.out.println("Setting Fan Cooking Mode");
    }
}
