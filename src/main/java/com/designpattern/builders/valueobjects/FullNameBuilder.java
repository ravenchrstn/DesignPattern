package com.designpattern.builders.valueobjects;

import com.designpattern.models.valueobjects.FullName;

public class FullNameBuilder {
    private String firstName;
    private String middleName;
    private String lastName;

    public FullName build() {
        return new FullName(this.firstName, this.middleName, this.lastName);
    }

    public FullNameBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FullNameBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public FullNameBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
