package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.JpawithhibernateApplication;
import com.jpahibernate.jpawithhibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpawithhibernateApplication.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void retrieveStudentAndPassportDetails() {
        Student student= em.find(Student.class,200003L);

        logger.info("student -> {}",student);

        logger.info("passport -> {}",student.getPassport());
    }

}