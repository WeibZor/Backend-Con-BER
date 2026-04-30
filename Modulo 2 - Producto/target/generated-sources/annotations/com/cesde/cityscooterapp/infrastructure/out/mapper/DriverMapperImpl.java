package com.cesde.cityscooterapp.infrastructure.out.mapper;

import com.cesde.cityscooterapp.domain.Driver;
import com.cesde.cityscooterapp.infrastructure.out.entities.DriverEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-29T19:17:41-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class DriverMapperImpl implements DriverMapper {

    @Override
    public Driver toDomain(DriverEntity driverEntity) {
        if ( driverEntity == null ) {
            return null;
        }

        Driver driver = new Driver();

        driver.setId( driverEntity.getId() );
        driver.setName( driverEntity.getName() );
        driver.setLastName( driverEntity.getLastName() );
        driver.setPhone( driverEntity.getPhone() );
        driver.setEmail( driverEntity.getEmail() );
        driver.setPassword( driverEntity.getPassword() );
        driver.setStatus( driverEntity.isStatus() );
        driver.setTypeDriver( driverEntity.getTypeDriver() );
        driver.setPoints( driverEntity.getPoints() );
        driver.setIsPenalized( driverEntity.getIsPenalized() );

        return driver;
    }

    @Override
    public DriverEntity toEntity(Driver driver) {
        if ( driver == null ) {
            return null;
        }

        DriverEntity driverEntity = new DriverEntity();

        driverEntity.setEmail( driver.getEmail() );
        driverEntity.setId( driver.getId() );
        driverEntity.setIsPenalized( driver.getIsPenalized() );
        driverEntity.setLastName( driver.getLastName() );
        driverEntity.setName( driver.getName() );
        driverEntity.setPassword( driver.getPassword() );
        driverEntity.setPhone( driver.getPhone() );
        driverEntity.setPoints( driver.getPoints() );
        driverEntity.setStatus( driver.isStatus() );
        driverEntity.setTypeDriver( driver.getTypeDriver() );

        return driverEntity;
    }

    @Override
    public List<Driver> toDomainList(List<DriverEntity> driverEntities) {
        if ( driverEntities == null ) {
            return null;
        }

        List<Driver> list = new ArrayList<Driver>( driverEntities.size() );
        for ( DriverEntity driverEntity : driverEntities ) {
            list.add( toDomain( driverEntity ) );
        }

        return list;
    }
}
