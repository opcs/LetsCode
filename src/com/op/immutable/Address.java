package com.op.immutable;

public class Address implements Cloneable{

    public Address() {
    }

    public Address(String streetName, int streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    private String streetName;
    private int streetNumber;
    
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	} 

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
