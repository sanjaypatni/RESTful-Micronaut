package com.pluralsight.smart.oven.m3.scopes;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Prototype;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;

@Prototype
public class Lights {

    public Lights() {
        System.out.println("Calling Lights  constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Calling Lights @PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Calling Lights @PreDestroy");
    }
}
