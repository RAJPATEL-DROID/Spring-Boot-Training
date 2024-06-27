package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.JpawithhibernateApplication;
import com.jpahibernate.jpawithhibernate.entity.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpawithhibernateApplication.class)
class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jpql_basic() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_course", Course.class);

        List resultList = query.getResultList();

        logger.info("result  : {}", resultList);
    }

    @Test
    void jpql_where() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%100 Steps'",Course.class);

        List resultList = query.getResultList();

        logger.info("result  : {}", resultList);
    }


}