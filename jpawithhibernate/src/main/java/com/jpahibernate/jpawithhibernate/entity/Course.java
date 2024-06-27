package com.jpahibernate.jpawithhibernate.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "CourseDetails")
@NamedQuery(name="query_get_all_course",query="Select c from Course c")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy="course")
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course(){};

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
