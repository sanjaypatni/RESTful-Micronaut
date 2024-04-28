package com.pluralsight.smart.oven.m3.qualifiers;

import com.pluralsight.smart.oven.m3.qualifiers.modes.CookingMode;
import com.pluralsight.smart.oven.m3.qualifiers.modes.GrillCookingMode;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Oven {

    private CookingMode cookingMode;

    @Inject
    public Oven(@Defrosting CookingMode cookingMode) {
        this.cookingMode = cookingMode;
    }

    public void setCookingMode() {
        cookingMode.setCookingMode();
    }
}
