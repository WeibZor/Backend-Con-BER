package com.example.sstretencion.repository;

import com.example.sstretencion.model.Absenteeism;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenteeismRepository extends JpaRepository<Absenteeism, Long> {
}