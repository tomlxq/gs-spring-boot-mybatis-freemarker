package com.tom.domain;

/**
 * Created by tom on 2016/5/14.
 */
public class City extends IdEntity {
    private String name;

    private String state;

    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
