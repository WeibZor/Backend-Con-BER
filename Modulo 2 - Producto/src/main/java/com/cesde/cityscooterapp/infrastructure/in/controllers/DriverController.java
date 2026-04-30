package com.cesde.cityscooterapp.infrastructure.in.controllers;


import com.cesde.cityscooterapp.domain.Driver;
import com.cesde.cityscooterapp.application.inputport.DriverUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class DriverController {


    private final DriverUseCase driverUseCase;

    public DriverController( DriverUseCase driverUseCase) {
        this.driverUseCase = driverUseCase;
    }


    @PostMapping("/create")
    ResponseEntity<Driver> createDriver(@Valid @RequestBody Driver driver){
        Driver savedDriver = driverUseCase.createrDriver(driver);
        return ResponseEntity.ok(savedDriver);
    }


    @GetMapping("/{id}")
    ResponseEntity<Driver> getDriverById(@PathVariable int id) {
        return driverUseCase.getDriverById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
