package com.cesde.cityscooterapp.infrastructure.out.mapper;


import com.cesde.cityscooterapp.domain.Driver;
import com.cesde.cityscooterapp.infrastructure.out.entities.DriverEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {

   Driver toDomain(DriverEntity driverEntity);
   DriverEntity toEntity(Driver driver);

    List<Driver> toDomainList(List<DriverEntity> driverEntities);

}
