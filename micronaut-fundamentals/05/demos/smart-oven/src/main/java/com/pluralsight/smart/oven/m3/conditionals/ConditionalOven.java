package com.pluralsight.smart.oven.m3.conditionals;

import com.pluralsight.smart.oven.m3.conditionals.modes.CookingMode;
import com.pluralsight.smart.oven.m3.conditionals.modes.FanCookingMode;
import com.pluralsight.smart.oven.m3.qualifiers.Defrosting;
import io.micronaut.context.annotation.Requires;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Requires(property = "safety.switch.enabled", value = "true")
public class ConditionalOven {

    private CookingMode cookingMode;

    @Inject
    public ConditionalOven(CookingMode cookingMode) {
        this.cookingMode = cookingMode;
    }

    public void setCookingMode() {
        cookingMode.setCookingMode();
    }
}
