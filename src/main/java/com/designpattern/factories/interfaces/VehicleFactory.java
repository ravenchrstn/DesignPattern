package com.designpattern.factories.interfaces;

import java.util.ArrayList;

import com.designpattern.models.interfaces.Bike;
import com.designpattern.models.interfaces.Car;

public interface VehicleFactory {
    public Car createCar(String brand, String model, String color, int year, int numberOfDoors, ArrayList<String> features, double price, boolean isElectric);
    public Bike createBike(String brand, String model, String color, int year, boolean hasCarrier, boolean isElectric,
            double price, ArrayList<String> features);
}
