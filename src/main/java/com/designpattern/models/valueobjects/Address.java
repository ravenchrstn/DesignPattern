package com.designpattern.models.valueobjects;

public class Address {
    private String streetName;
    private String buildingNumber;
    private String postalCode;
    private String city;
    private String state;

    public Address(String streetName, String buildingNumber, String postalCode, String city, String state) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
