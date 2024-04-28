package com.pluralsight.springjit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OvenController {

    @GetMapping("/status/{ovenId}")
    public String getOvenStatus(@PathVariable String id) {
        return "OK";
    }
}
