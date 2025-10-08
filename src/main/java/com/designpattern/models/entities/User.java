package com.designpattern.models.entities;

import com.designpattern.models.valueobjects.Address;
import com.designpattern.models.valueobjects.FullName;

public class User {
    private int userId;
    private FullName name;
    private int age;
    private Address address;

    public User(int userId, FullName name, int age, Address address) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
