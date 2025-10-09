package com.designpattern.models.interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class Bike implements Cloneable {
    protected String brand;
    protected String model;
    protected String color;
    protected int year;
    protected boolean hasCarrier;
    protected boolean isElectric;
    protected double price;
    protected ArrayList<String> features;

    public Bike(String brand, String model, String color, int year, boolean hasCarrier, boolean isElectric,
            double price, ArrayList<String> features) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.hasCarrier = hasCarrier;
        this.isElectric = isElectric;
        this.price = price;
        this.features = features;
    }

    public Bike bikeClone() {
        try {
            Bike clonedBike = (Bike) super.clone();
            clonedBike.setFeatures(new ArrayList<>(clonedBike.getFeatures()));
            return clonedBike;
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

    public boolean isHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }

}
