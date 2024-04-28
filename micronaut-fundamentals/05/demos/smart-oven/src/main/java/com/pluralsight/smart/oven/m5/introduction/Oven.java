package com.pluralsight.smart.oven.m5.introduction;

import io.micronaut.context.annotation.Context;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Context
public class Oven {

    private UpdatesControlCenter updatesControlCenter;

    @Inject
    public Oven(UpdatesControlCenter updatesControlCenter) {
        this.updatesControlCenter = updatesControlCenter;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(updatesControlCenter.getLatestVersion());
    }
}
