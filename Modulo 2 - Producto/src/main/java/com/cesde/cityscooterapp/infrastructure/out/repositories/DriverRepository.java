package com.cesde.cityscooterapp.infrastructure.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesde.cityscooterapp.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}