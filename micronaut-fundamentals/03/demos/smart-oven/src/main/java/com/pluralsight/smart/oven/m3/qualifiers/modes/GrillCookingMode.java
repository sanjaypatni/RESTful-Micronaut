package com.pluralsight.smart.oven.m3.qualifiers.modes;

import javax.inject.Singleton;

@Singleton
public class GrillCookingMode implements CookingMode {
    @Override
    public void setCookingMode() {
        System.out.println("Setting Grill Cooking Mode");
    }
}
