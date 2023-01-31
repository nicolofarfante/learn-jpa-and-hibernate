package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepo;

    @Autowired
    private CourseJpaRepository courseJpaRepo;

    @Autowired
    private CourseSpringDataRepository courseSpringDataRepo;

    @Override
    public void run(String... args) throws Exception {
        // courseJdbcRepo.insert(new Course(1, "Learn Rust", "in28minutes"));
        // courseJdbcRepo.insert(new Course(2, "Learn Java", "in28minutes"));
        // courseJdbcRepo.insert(new Course(3, "Learn Solidity", "in28minutes"));
        //courseJpaRepo.insert(new Course(1, "Learn Rust", "in28minutes"));
        //courseJpaRepo.insert(new Course(2, "Learn Java", "in28minutes"));
        //courseJpaRepo.insert(new Course(3, "Learn Solidity", "in28minutes"));

        courseSpringDataRepo.save(new Course(1, "Learn AWS", "in28minutes"));
        courseSpringDataRepo.save(new Course(2, "Learn Solidity", "in28minutes"));
        courseSpringDataRepo.save(new Course(3, "Learn Java", "in28minutes"));

        System.out.println(courseSpringDataRepo.findAll());
        System.out.println(courseSpringDataRepo.count());
        System.out.println(courseSpringDataRepo.findByAuthor("in28minutes"));
        System.out.println(courseSpringDataRepo.findByName("Learn AWS"));


        // courseJdbcRepo.delete(1);
        //courseJpaRepo.deleteById(1);

        courseSpringDataRepo.deleteById(1l);


        // System.out.println(courseJdbcRepo.select(2));
        // System.out.println(courseJdbcRepo.select(3));
        //System.out.println(courseJpaRepo.findById(2));
        //System.out.println(courseJpaRepo.findById(3));

        courseSpringDataRepo.findById(2l);
        courseSpringDataRepo.findById(3l);


    }
}
