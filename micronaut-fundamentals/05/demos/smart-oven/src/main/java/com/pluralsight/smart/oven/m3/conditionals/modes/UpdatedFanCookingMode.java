package com.pluralsight.smart.oven.m3.conditionals.modes;

import io.micronaut.context.annotation.Replaces;

import javax.inject.Singleton;

@Singleton
@Replaces(FanCookingMode.class)
public class UpdatedFanCookingMode implements CookingMode {
    @Override
    public void setCookingMode() {
        System.out.println("Setting Updated Fan Cooking Mode");
    }
}
