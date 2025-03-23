package com.ttdat.LargeResponse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable {
    private int id;
    private String first_name;
    private String last_name;
    private String street;
    private String city;
    private String country;
    private String phone_number;
    private String email;

    public Users() {
    }

    public Users(int id, String first_name, String last_name, String street, String city, String country, String phone_number, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street = street;
        this.city = city;
        this.country = country;
        this.phone_number = phone_number;
        this.email = email;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

