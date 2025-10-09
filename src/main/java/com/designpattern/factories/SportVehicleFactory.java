package com.designpattern.factories;

import java.util.ArrayList;

import com.designpattern.factories.interfaces.VehicleFactory;
import com.designpattern.models.entities.SportBike;
import com.designpattern.models.entities.SportCar;
import com.designpattern.models.interfaces.Bike;
import com.designpattern.models.interfaces.Car;

public class SportVehicleFactory implements VehicleFactory {
    public static SportVehicleFactory svf;

    public static SportVehicleFactory getInstance() {
        if (svf == null) svf = new SportVehicleFactory();
        return svf;
    }

    @Override
    public Car createCar(String brand, String model, String color, int year, int numberOfDoors, ArrayList<String> features, double price, boolean isElectric) {
        return new SportCar(brand, model, color, year, numberOfDoors, features, price, isElectric);
    }

    @Override
    public Bike createBike(String brand, String model, String color, int year, boolean hasCarrier, boolean isElectric,
            double price, ArrayList<String> features) {
        return new SportBike(brand, model, color, year, hasCarrier, hasCarrier, price, features);
    }
    
}
