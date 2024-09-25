package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.h1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;



public class XmlConfigurationContextLauncherAplication {

    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            System.out.println(context);
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("game"));
            System.out.println(context.getBean("gamerunner"));


        }

    }


}
