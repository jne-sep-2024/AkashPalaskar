package com.traneeSE.learn_spring_framework.GammingAppLauncherApplication;

import com.traneeSE.learn_spring_framework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.traneeSE.learn_spring_framework.game")
public class GammingAppLauncherApplication {

//    @Bean
//    public GamingConsole game() {
//        var game = new PacmanGame();
//        return game;
//    }

//    @Bean
//    public GameRunner game2(GamingConsole game) {
//        System.out.println(game);
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
    //cut the boiler code by usign @ component at gameRunner and gameConsole
    //also by using componentscan


    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (GammingAppLauncherApplication.class)) {
//            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();;
        }

    }
}