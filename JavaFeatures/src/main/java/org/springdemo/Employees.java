package org.springdemo;

import java.util.List;

public class Employees {

    public Employees(int id, String name, String department,Rating rating) {
        Id = id;
        this.name = name;
        this.department = department;
        this.rating =rating;
    }

    public int Id;
    public String name;
    public String department;
    public Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
