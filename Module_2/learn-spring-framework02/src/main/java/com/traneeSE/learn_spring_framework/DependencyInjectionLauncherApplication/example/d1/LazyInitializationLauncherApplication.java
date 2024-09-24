package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}
@Component
class  ClassB{
    private ClassA classA;
    public  ClassB (ClassA classA){
        System.out.println("some Initialization logic");
        this.classA=classA;
    }

    public  void  doSomething(){
        System.out.println("do something");
    }

}
@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        try(var context =new AnnotationConfigApplicationContext
                (LazyInitializationLauncherApplication.class)){
            System.out.println("Initialization method is complete");

                context.getBean(ClassB.class).doSomething();


        }

    }


}
