package com.example.d1ex4arraylistofobjectsending.module;

public class Address {
    String name;
    int dep;
    String streetName;
    int pincode;
    String area;
    String district;
    String state;
    String country;
    
    public Address(String name, int dep, String streetName,int pincode , String district, String state,
            String country,String area ) {
        this.name = name;
        this.dep = dep;
        this.streetName = streetName;
        this.area = area;
        this.district = district;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDep() {
        return dep;
    }
    public void setDep(int dep) {
        this.dep = dep;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }


}
