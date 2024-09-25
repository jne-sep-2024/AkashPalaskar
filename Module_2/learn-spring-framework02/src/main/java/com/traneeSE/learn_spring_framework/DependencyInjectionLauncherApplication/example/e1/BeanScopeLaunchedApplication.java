package com.traneeSE.learn_spring_framework.DependencyInjectionLauncherApplication.example.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class  PrototypeClass{


}
@Configuration
@ComponentScan
public class BeanScopeLaunchedApplication {

    public static void main(String[] args) {
        try(var context =new AnnotationConfigApplicationContext
                (BeanScopeLaunchedApplication.class)){
            System.out.println("Initialization method is complete");
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }

    }


}
