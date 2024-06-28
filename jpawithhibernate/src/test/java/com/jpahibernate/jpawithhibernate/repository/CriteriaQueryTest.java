package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.JpawithhibernateApplication;
import com.jpahibernate.jpawithhibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.platform.engine.support.descriptor.ClassSource.from;

@SpringBootTest(classes = JpawithhibernateApplication.class)
class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void all_courses() {
        // "Select c from Course c"

        // 1. Use Criteria Builder to create a Criteria Query -> Returning the expected Result Object
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define roots for tables which are involved in Query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define Predicates etc using Criteria Builder

        // 4. Add Predicates etc to Criteria Query

        // 5. Build the Query using Typed Query and EM
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();

        logger.info("Typed Query Result  : {}", resultList);
    }


    @Test
    void all_courses_having_100steps() {
        // "Select c from Course c"

        // 1. Use Criteria Builder to create a Criteria Query -> Returning the expected Result Object
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define roots for tables which are involved in Query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define Predicates etc using Criteria Builder
        Predicate like100steps = cb.like(courseRoot.get("name"),"%100 Steps");

        // 4. Add Predicates etc to Criteria Query
        cq.where(like100steps);

        // 5. Build the Query using Typed Query and EM
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();

        logger.info("Typed Query Result  : {}", resultList);
    }

    @Test
    void all_courses_without_students() {
        // "Select c from Course c "

        // 1. Use Criteria Builder to create a Criteria Query -> Returning the expected Result Object
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define roots for tables which are involved in Query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define Predicates etc using Criteria Builder
        Predicate studentsIsEmty = cb.isEmpty(courseRoot.get("students"));

        // 4. Add Predicates etc to Criteria Query
        cq.where(studentsIsEmty);

        // 5. Build the Query using Typed Query and EM
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();

        logger.info("Typed Query Result  : {}", resultList);
    }

    @Test
    void join() {
        // "Select c from Course c join c.students s"

        // 1. Use Criteria Builder to create a Criteria Query -> Returning the expected Result Object
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define roots for tables which are involved in Query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define Predicates etc using Criteria Builder
        Join<Object,Object> join = courseRoot.join("students");

        // 4. Add Predicates etc to Criteria Query

        // 5. Build the Query using Typed Query and EM
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();

        logger.info("Typed Query Result  : {}", resultList);
    }

    @Test
    void leftJoin() {
        // "Select c from Course c left join c.students s"

        // 1. Use Criteria Builder to create a Criteria Query -> Returning the expected Result Object
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define roots for tables which are involved in Query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define Predicates etc using Criteria Builder
        Join<Object,Object> join = courseRoot.join("students",JoinType.LEFT);

        // 4. Add Predicates etc to Criteria Query

        // 5. Build the Query using Typed Query and EM
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();

        logger.info("Typed Query Result  : {}", resultList);
    }


}