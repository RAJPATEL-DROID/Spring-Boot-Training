package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.JpawithhibernateApplication;
import com.jpahibernate.jpawithhibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Queue;

@SpringBootTest(classes = JpawithhibernateApplication.class)
class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void native_basic() {
        Query query = em.createNativeQuery("SELECT * FROM Course_Details",Course.class);

        List resultList = query.getResultList();

        logger.info("result  : {}", resultList);
    }

}