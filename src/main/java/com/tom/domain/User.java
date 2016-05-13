package com.tom.domain;

/**
 * Created by tom on 2016/5/13.
 */
public class User extends IdEntity {
    private String name;
    private String email;
    public User() {
    }
    public User(Long id, String name, String email) {
        this.id=id;
        this.name=name;
        this.email=email;
    }

    // setters & getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
