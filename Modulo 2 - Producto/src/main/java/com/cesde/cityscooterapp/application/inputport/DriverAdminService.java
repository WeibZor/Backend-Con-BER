package com.cesde.cityscooterapp.application.inputport;

import com.cesde.cityscooterapp.domain.Driver;

import java.util.List;

public interface DriverAdminService {

    List<Driver> getAllDrivers();
    void deleteDriverById(int id);


}
