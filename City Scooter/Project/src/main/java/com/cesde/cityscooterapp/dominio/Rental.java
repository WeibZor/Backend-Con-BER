package com.cesde.cityscooterapp.dominio;

import java.time.LocalDateTime;

public class Rental {
    private int id;
    private Customer customer;
    private Scooter scooter;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalCost;

    public Rental() {
    }

    public Rental(int id, Customer customer, Scooter scooter, LocalDateTime startTime, LocalDateTime endTime, double totalCost) {
        this.id = id;
        this.customer = customer;
        this.scooter = scooter;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", customer=" + customer +
                ", scooter=" + scooter +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalCost=" + totalCost +
                '}';
    }
}
