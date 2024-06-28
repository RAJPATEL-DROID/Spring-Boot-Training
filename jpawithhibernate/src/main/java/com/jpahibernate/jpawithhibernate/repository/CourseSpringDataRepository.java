package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
