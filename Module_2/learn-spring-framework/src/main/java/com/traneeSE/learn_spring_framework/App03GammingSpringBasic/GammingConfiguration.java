package com.traneeSE.learn_spring_framework.App03GammingSpringBasic;

import com.traneeSE.learn_spring_framework.game.GameRunner;
import com.traneeSE.learn_spring_framework.game.GamingConsole;
import com.traneeSE.learn_spring_framework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GammingConfiguration {
    @Bean
    public GamingConsole game() {
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner game2(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

}
