package com.traneeSE.learn_jpa_hibernate.course.jdbc;

import com.traneeSE.learn_jpa_hibernate.course.Course;
import com.traneeSE.learn_jpa_hibernate.course.jpa.CourseJpaRepository;
import com.traneeSE.learn_jpa_hibernate.course.springDataJpa.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private  CourseJdbcRepository repository;

//@Autowired
//private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.save(new Course(1,"learn AWS","think"));
        repository.save(new Course(2,"learn DevOps","think"));

        repository.save(new Course(3,"learn Kafka","thinking"));

        repository.deleteById(2l);
        System.out.println(repository.findById(3l).get());
        System.out.println(repository.findById(1l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("think"));
        System.out.println(repository.findByName("learn Kafka"));






    }
}
