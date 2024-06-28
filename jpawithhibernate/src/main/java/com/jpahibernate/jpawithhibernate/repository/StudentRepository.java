package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.entity.Passport;
import com.jpahibernate.jpawithhibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id){

        return em.find(Student.class, id);
    };

    public void deleteById(Long id){
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

    public void saveStudentWithPassport()
    {
        Passport passport = new Passport("Z232FD");

        em.persist(passport);

        Student student =  new Student("Mike");

        student.setPassport(passport);

        em.persist(student);
    }


}
