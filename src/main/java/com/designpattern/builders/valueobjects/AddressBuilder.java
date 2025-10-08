package com.designpattern.builders.valueobjects;

import com.designpattern.models.valueobjects.Address;

public class AddressBuilder {
    private String streetName;
    private String buildingNumber;
    private String postalCode;
    private String city;
    private String state;

    public Address build() {
        return new Address(this.streetName, this.buildingNumber, this.postalCode, this.city, this.state);
    }

    public AddressBuilder setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressBuilder setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public AddressBuilder setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }
}
