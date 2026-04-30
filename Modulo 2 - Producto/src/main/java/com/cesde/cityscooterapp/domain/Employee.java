package com.cesde.cityscooterapp.domain;

import com.cesde.cityscooterapp.domain.enums.RolEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User{

    @Enumerated(EnumType.STRING)
    private RolEnum rol;



}
