package com.jpahibernate.jpawithhibernate.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String passportNumber;

    @OneToOne(fetch=FetchType.LAZY, mappedBy = "passport")
    public Student student;
    public Passport(String passport_number) {
        this.passportNumber = passport_number;
    }

    public Passport() {

    }

    public int getId() {
        return id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String name) {
        this.passportNumber = name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + passportNumber + '\'' +
                '}';
    }


}
