package com.cesde.cityscooterapp.infrastructure.in.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesde.cityscooterapp.application.inputport.HelloWorldService;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/helloworld")
    public String createGreetings(){

        return helloWorldService.createSalute();

    }



}
