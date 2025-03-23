package com.ttdat.LargeResponse.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class usersShorter implements Serializable {
    private int id;
    private String first_name;

    private String last_name;
    private String street;

    private String city;
    private String country;
    private String phone_number;
    private String email;

    public usersShorter() {
    }

    public usersShorter(int id, String first_name, String last_name, String street, String city, String country, String phone_number, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street = street;
        this.city = city;
        this.country = country;
        this.phone_number = phone_number;
        this.email = email;
    }
    @JsonGetter("fn")
    public String getFirst_name() {
        return first_name;
    }
    @JsonSetter("first_name")
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    @JsonGetter("ln")
    public String getLast_name() {
        return last_name;
    }
    @JsonSetter("last_name")
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @JsonGetter("p")
    public String getPhone_number() {
        return phone_number;
    }
    @JsonSetter("phone_number")
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    // Getters and setters
    @JsonGetter("i")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @JsonGetter("s")
    public String getStreet() {
        return street;
    }
    @JsonSetter("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonGetter("c")
    public String getCity() {
        return city;
    }
    @JsonSetter("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonGetter("cn")
    public String getCountry() {
        return country;
    }

    @JsonSetter("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonGetter("e")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }


}

