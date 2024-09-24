package com.traneeSE.learn_spring_framework.App03GammingSpringBasic;

import com.traneeSE.learn_spring_framework.game.GameRunner;
import com.traneeSE.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GammingSpringBeans {
    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (GammingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();;
        }

    }
}