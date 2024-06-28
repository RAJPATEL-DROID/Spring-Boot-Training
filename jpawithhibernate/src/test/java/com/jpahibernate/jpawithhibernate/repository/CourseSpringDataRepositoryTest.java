
package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.JpawithhibernateApplication;
import com.jpahibernate.jpawithhibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpawithhibernateApplication.class)
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresentTest(){
        Optional<Course> courseOptional = repository.findById(10001L);

        assertTrue(courseOptional.isPresent());
        logger.info("{}", courseOptional.get().getName());
    }

    @Test
    public void findById2_CourseNotPresentTest(){
        Optional<Course> courseOptional = repository.findById(10009L);

        assertFalse(courseOptional.isPresent());
    }


}