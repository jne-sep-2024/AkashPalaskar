package com.example.learn_spring_aop;

import com.example.learn_spring_aop.business.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
    private BusinessService1 businessService1;

//    @Autowired
    public LearnSpringAopApplication(BusinessService1 businessService1) {
        this.businessService1 = businessService1;
    }

    private Logger logger = LoggerFactory.getLogger(LearnSpringAopApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(LearnSpringAopApplication.class, args);
        System.out.println("aop");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("value retrive is {} : "+businessService1.calculateMax());
    }
}
