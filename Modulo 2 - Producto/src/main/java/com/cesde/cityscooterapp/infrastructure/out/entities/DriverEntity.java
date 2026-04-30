package com.cesde.cityscooterapp.infrastructure.out.entities;


import com.cesde.cityscooterapp.domain.enums.IsPenalizedEnum;
import com.cesde.cityscooterapp.domain.enums.TypeDriverEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drivers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private boolean status;
    @Column(name = "type_driver", nullable = false)
    private TypeDriverEnum typeDriver;
    private Integer points;
    private IsPenalizedEnum isPenalized;



}
