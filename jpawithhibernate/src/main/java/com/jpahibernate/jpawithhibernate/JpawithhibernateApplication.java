package com.jpahibernate.jpawithhibernate;

import com.jpahibernate.jpawithhibernate.entity.Course;
import com.jpahibernate.jpawithhibernate.entity.Review;
import com.jpahibernate.jpawithhibernate.repository.CourseRepository;
import com.jpahibernate.jpawithhibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpawithhibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpawithhibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		logger.info("{}",courseRepository.findById(10001L));
//
//		courseRepository.deleteById(10003L);
//
//		courseRepository.save(new Course("New Course"));

//		courseRepository.playWithEntityManager();

		List<Review> reviewList = new ArrayList<>();
		reviewList.add(new Review("Bad Teaching", "1"));
		reviewList.add(new Review("Mediocre","2"));

		courseRepository.addReviewForCourse(1003L,reviewList);
		studentRepository.saveStudentWithPassport();

	}


}
