package com.pluralsight.smart.oven.m4.properties;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;

import javax.annotation.PostConstruct;

@Context
@ConfigurationProperties("lights.default")
public class LightsProperties {

    private String color;
    private Integer dim;
    private Boolean enabled;

    //@PostConstruct
    public void postConstruct() {
        System.out.println("Color: " + color);
        System.out.println("Dim: " + dim);
        System.out.println("Enabled: " + enabled);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDim() {
        return dim;
    }

    public void setDim(Integer dim) {
        this.dim = dim;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
