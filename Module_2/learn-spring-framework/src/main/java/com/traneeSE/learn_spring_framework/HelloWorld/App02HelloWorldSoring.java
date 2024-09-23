package com.traneeSE.learn_spring_framework.HelloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

//Eliminate VErbosity in crating java beans
//public accessor  mathods  , constructor
//equat , hashcode, toString , are automaticlly created , dont have to make getter ans setter
// released in java 16


public class App02HelloWorldSoring {

    public static void main(String[] args) {
        //launch a spring context

        try (var context =
                     new AnnotationConfigApplicationContext
                             (HelloWorldConfiguration.class)) {

            //configure the thing that we want spring to manage  - @Configuration
            //name - @Bean

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MehodCall"));
            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Person.class));
            System.out.println("----------------");

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("person5Parameters"));

        }


    }
}
