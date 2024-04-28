package com.pluralsight.smart.oven.m4.properties;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Context;
import io.micronaut.core.convert.format.MapFormat;

import javax.annotation.PostConstruct;
import java.util.Map;

@ConfigurationProperties("sensor")
@Context
public class SensorProperties {

    @MapFormat(transformation = MapFormat.MapTransformation.FLAT)
    private Map<String, String> thresholds;

    //@PostConstruct
    public void postConstruct() {
        thresholds.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public Map<String, String> getThresholds() {
        return thresholds;
    }

    public void setThresholds(Map<String, String> thresholds) {
        this.thresholds = thresholds;
    }
}
