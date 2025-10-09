package com.designpattern.models.interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class Car implements Cloneable {
    protected String brand;
    protected String model;
    protected String color;
    protected int year;
    protected int numberOfDoors;
    protected List<String> features;
    protected double price;
    protected boolean isElectric;

    public Car(String brand, String model, String color, int year, int numberOfDoors, List<String> features,
            double price, boolean isElectric) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
        this.features = features;
        this.price = price;
        this.isElectric = isElectric;
    }

    public Car carClone() {
        try {
            Car clonedCar = (Car) super.clone();
            clonedCar.setFeatures(new ArrayList<>(clonedCar.getFeatures()));
            return clonedCar;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    public abstract void drive();
}
