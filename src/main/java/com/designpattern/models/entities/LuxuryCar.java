package com.designpattern.models.entities;

import java.util.ArrayList;

import com.designpattern.models.interfaces.Car;

public class LuxuryCar extends Car {
    public LuxuryCar(String brand, String model, String color, int year, int numberOfDoors, ArrayList<String> features,
            double price, boolean isElectric) {
        super(brand, model, color, year, numberOfDoors, features, price, isElectric);
    }

    public void drive() {
        System.out.println("driving a luxury car now!");
    }
}
