/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.oops.immutable;

 final class Employee {

    private final int id;
    private Address address;

    public Employee(int id, final Address address)
    {
        this.id = id;
        // use defensive copy to make it immutable
        this.address = new Address(address.getStreetName(), address.getStreetNumber());
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", address=" + address + "]";
    }

}

class Address {

    public Address() {
    }

    public Address(String streetName, int streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    private String streetName;
    private int streetNumber;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "Address [streetName=" + streetName + ", streetNumber=" + streetNumber + "]";
    }

}
