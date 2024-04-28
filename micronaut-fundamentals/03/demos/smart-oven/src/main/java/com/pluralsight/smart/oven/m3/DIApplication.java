package com.pluralsight.smart.oven.m3;


import com.pluralsight.smart.oven.m3.beans.Grill;
import com.pluralsight.smart.oven.m3.beans.Lights;
import com.pluralsight.smart.oven.m3.beans.Oven;
import io.micronaut.context.BeanContext;

public class DIApplication {

    public static void main(String[] args) {
        BeanContext context = BeanContext.run();
        Oven oven = context.getBean(Oven.class);
        oven.turnOn();
    }
}
