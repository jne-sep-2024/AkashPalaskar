package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class SomeClass {
    private  SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("initialized DI");
    }

    @PostConstruct
    public  void initialized(){
        someDependency.getReady();
    }

    @PreDestroy
    public  void cleanup(){
        System.out.println("cleanup");
    }
}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("get ready logic");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationLuncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
                (PrePostAnnotationLuncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }

    }


}
