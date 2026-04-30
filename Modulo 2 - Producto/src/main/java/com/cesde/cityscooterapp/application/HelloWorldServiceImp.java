package com.cesde.cityscooterapp.application;

import org.springframework.stereotype.Service;

import com.cesde.cityscooterapp.application.inputport.HelloWorldService;

@Service
public class HelloWorldServiceImp implements HelloWorldService {

    @Override
    public String createSalute() {
        return "Hello World!";
    }
}