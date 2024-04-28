package com.pluralsight.smart.oven.controller;

import com.pluralsight.smart.oven.event.Notification;
import com.pluralsight.smart.oven.service.OvenService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/oven")
public class OvenController {

    private OvenService ovenService;

    public OvenController(OvenService ovenService) {
        this.ovenService = ovenService;
    }

    @Get("/start")
    public Single<Notification> startOven() {
        return ovenService.startOven();
    }

}
