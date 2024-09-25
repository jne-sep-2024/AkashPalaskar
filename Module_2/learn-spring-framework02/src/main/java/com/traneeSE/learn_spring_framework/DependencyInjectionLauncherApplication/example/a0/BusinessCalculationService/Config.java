package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.a0.BusinessCalculationService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Config.class);

        var bean = context.getBean(BusinessCalculationService.class).findmax();
        System.out.println(bean);
    }
}
