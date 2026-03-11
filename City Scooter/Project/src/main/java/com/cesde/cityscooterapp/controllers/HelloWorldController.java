package com.cesde.cityscooterapp.controllers;

import com.cesde.cityscooterapp.services.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return helloWorldService.getHelloMessage();
    }
}
