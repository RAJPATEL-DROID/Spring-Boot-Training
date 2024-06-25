package com.restapi.restwithspring.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class userDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String role;

    public userDetails(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public userDetails() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "userDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

