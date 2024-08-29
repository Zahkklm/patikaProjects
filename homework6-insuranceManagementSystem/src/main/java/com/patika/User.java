package com.patika;

import java.util.ArrayList;
import java.util.Date;

interface Address {
    String getFullAddress();
}

class HomeAddress implements Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public HomeAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFullAddress() {
        return String.format("Home Address: %s, %s, %s", street, city, postalCode);
    }
}

class BusinessAddress implements Address {
    private final String companyName;
    private final String street;
    private final String city;
    private final String postalCode;

    public BusinessAddress(String companyName, String street, String city, String postalCode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFullAddress() {
        return String.format("Business Address: %s, %s, %s, %s", companyName, street, city, postalCode);
    }
}

class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String profession;
    private final int age;
    private final ArrayList<Address> addresses;
    private Date lastLoginDate;

    public User(String firstName, String lastName, String email, String password, String profession, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profession = profession;
        this.age = age;
        this.addresses = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("User: %s %s\nEmail: %s\nProfession: %s\nAge: %d\nLast Login: %s",
                firstName, lastName, email, profession, age, lastLoginDate);
    }
}

