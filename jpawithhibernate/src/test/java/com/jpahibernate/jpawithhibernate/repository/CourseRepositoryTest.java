package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.JpawithhibernateApplication;
import com.jpahibernate.jpawithhibernate.entity.Course;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpawithhibernateApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    void findById_IdExistInRepository() {
        Course course = courseRepository.findById(10001L);
        assertEquals(10001L, course.getId());
        assertEquals("JPA in 100 Steps",course.getName());
        logger.info("Test is running");
    }

    @Test
    @DirtiesContext
    void deleteById_IdExistInRepository()
    {
        courseRepository.deleteById(10002L);

        assertNull(courseRepository.findById(10002L));

        logger.info("Test is running");
    }

    @Test
    @DirtiesContext
    void save_updateCourseTest(){
        Course course = courseRepository.findById(10001L);

        course.setName("JPA in 50 Steps");

        courseRepository.save(course);

        assertEquals(10001L, course.getId());
        assertEquals("JPA in 50 Steps", course.getName());

    }

    void playWithEntityManager_test(){}



}