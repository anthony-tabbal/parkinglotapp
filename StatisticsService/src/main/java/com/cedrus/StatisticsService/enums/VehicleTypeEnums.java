package com.cedrus.StatisticsService.enums;

public enum VehicleTypeEnums {

    Car("Compact"),
    Truck("Large"),
    Van("Large"),
    Handicapped("Handicapped"),
    Motorcycle("Motorcycle");

    private final String type;

    private VehicleTypeEnums(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}