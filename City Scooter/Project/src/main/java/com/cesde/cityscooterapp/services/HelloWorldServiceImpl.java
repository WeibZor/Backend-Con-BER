package com.cesde.cityscooterapp.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String getHelloMessage() {
        return "¡Hola desde CityscooterApp!";
    }
}
