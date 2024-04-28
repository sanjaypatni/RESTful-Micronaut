package com.pluralsight.smart.oven.m3;

import com.pluralsight.smart.oven.m3.qualifiers.Oven;
import io.micronaut.context.BeanContext;

public class QualifiersApplication {

    public static void main(String[] args) {
        BeanContext context = BeanContext.run();
        Oven oven = context.getBean(Oven.class);
        oven.setCookingMode();
    }
}
