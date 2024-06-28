package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee) {
        em.persist(employee);
    }

//    public List<Employee> retrieveAllEmployees() {
//        return em.createQuery("select e from Employee e", Employee.class).getResultList();
//    }

    public List<PartTimeEmployee> retrievePartTimeEmployees() {
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }


    public List<FullTimeEmployee> retrieveFullTimeEmployees() {
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }
}
