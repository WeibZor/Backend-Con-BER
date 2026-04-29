package com.example.sstretencion.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String description;
    private LocalDate date;
    private String status; // open, closed
    private String investigationNotes;

    // Constructors, getters, setters
    public Incident() {}

    public Incident(Employee employee, String description, LocalDate date, String status) {
        this.employee = employee;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getInvestigationNotes() { return investigationNotes; }
    public void setInvestigationNotes(String investigationNotes) { this.investigationNotes = investigationNotes; }
}