package com.example.sstretencion.service;

import com.example.sstretencion.model.Employee;
import com.example.sstretencion.model.Incident;
import com.example.sstretencion.model.Absenteeism;
import com.example.sstretencion.repository.EmployeeRepository;
import com.example.sstretencion.repository.IncidentRepository;
import com.example.sstretencion.repository.AbsenteeismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SstIndicatorsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private AbsenteeismRepository absenteeismRepository;

    public double calculateAccidentRate() {
        List<Employee> employees = employeeRepository.findAll();
        List<Incident> incidents = incidentRepository.findAll();
        if (employees.isEmpty()) return 0.0;
        return (double) incidents.size() / employees.size();
    }

    public double calculateAbsenteeismRate() {
        List<Employee> employees = employeeRepository.findAll();
        List<Absenteeism> absenteeisms = absenteeismRepository.findAll();
        if (employees.isEmpty()) return 0.0;
        // Simple calculation: total absenteeism days / (employees * 365)
        int totalDays = absenteeisms.stream().mapToInt(a -> a.getStartDate().until(a.getEndDate()).getDays()).sum();
        return (double) totalDays / (employees.size() * 365);
    }
}