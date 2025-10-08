package com.designpattern.builders.entities;

import com.designpattern.models.entities.User;
import com.designpattern.models.valueobjects.Address;
import com.designpattern.models.valueobjects.FullName;

public class UserBuilder {
        private int userId;
        private FullName name;
        private int age;
        private Address address;

        public UserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setName(FullName name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this.userId, this.name, this.age, this.address);
        }
    }