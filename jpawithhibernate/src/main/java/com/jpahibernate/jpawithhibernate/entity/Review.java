package com.jpahibernate.jpawithhibernate.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private int id;

    private String rating;

    @ManyToOne
    private Course course;

    @Column(nullable = false)
    private String description;

    public Review(String description,String rating) {
        this.description =description;
        this.rating = rating;
    }

    public Review() {}

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + description +
                ", rating" + rating + '\'' +
                '}';
    }


}
