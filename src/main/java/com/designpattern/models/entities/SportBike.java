package com.designpattern.models.entities;

import java.util.ArrayList;

import com.designpattern.models.interfaces.Bike;

public class SportBike extends Bike {
    public SportBike(String brand, String model, String color, int year, boolean hasCarrier, boolean isElectric,
            double price, ArrayList<String> features) {
        super(brand, model, color, year, hasCarrier, isElectric, price, features);
    }

    public void drive() {
        System.out.println("driving a sport bike now!");
    }
}
