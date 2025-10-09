package com.designpattern.models.entities;

import java.util.ArrayList;

import com.designpattern.models.interfaces.Bike;

public class LuxuryBike extends Bike {
    public LuxuryBike(String brand, String model, String color, int year, boolean hasCarrier, boolean isElectric,
            double price, ArrayList<String> features) {
        super(brand, model, color, year, hasCarrier, isElectric, price, features);
    }

    public void drive() {
        System.out.println("driving a luxury bike now!");
    }
}
