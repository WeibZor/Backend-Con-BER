package com.cesde.cityscooterapp.dominio;

public class Scooter {
    private int id;
    private String model;
    private String plateNumber;
    private int batteryLevel;
    private boolean isAvailable;

    public Scooter() {
    }

    public Scooter(int id, String model, String plateNumber, int batteryLevel, boolean isAvailable) {
        this.id = id;
        this.model = model;
        this.plateNumber = plateNumber;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", batteryLevel=" + batteryLevel +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
