package com.pluralsight.smart.oven.m2.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class OvenController {

    @Get("/status/{ovenId}")
    public String getOvenStatus(String ovenId) {
        return "OK";
    }
}
