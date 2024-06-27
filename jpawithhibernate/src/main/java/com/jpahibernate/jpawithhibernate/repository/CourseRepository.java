package com.jpahibernate.jpawithhibernate.repository;

import com.jpahibernate.jpawithhibernate.entity.Course;
import com.jpahibernate.jpawithhibernate.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;
    @Autowired
    private StudentRepository studentRepository;

    public Course findById(Long id){

        return em.find(Course.class, id);
    };

    public void deleteById(Long id){
        Course course = em.find(Course.class, id);
        em.remove(course);
    }

    public Course save(Course course){

        if(course.getId()==null){
            em.persist(course);
        }
        else
        {
            em.merge(course);
        }

        return course;
    }

    public void playWithEntityManager()
    {
        em.persist(new Course("Web Dev in 20 steps"));

        em.flush();

        Course course = findById(10002L);
        course.setName("JPA");

        em.persist(course);
        em.flush();


        logger.info("Inside playWithEntityManager");
    }

    public void addReviewForCourse(Long courseId, List<Review> reviewList)  {
        // Get Course
        Course course = findById(10001L);

        // Add Review

        for(Review review : reviewList){

            course.addReview(review);

            review.setCourse(course);

            em.persist(review);
        }

    }
}
