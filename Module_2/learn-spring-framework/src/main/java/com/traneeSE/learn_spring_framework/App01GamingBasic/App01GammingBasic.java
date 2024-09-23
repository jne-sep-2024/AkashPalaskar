package com.traneeSE.learn_spring_framework.App01GamingBasic;

import com.traneeSE.learn_spring_framework.game.GameRunner;
import com.traneeSE.learn_spring_framework.game.PacmanGame;

public class App01GammingBasic {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame(); //obj creation
        var gameRunner = new GameRunner(game);
        //obj creation + wiring of dependency
        //game is deoendency  of game runner

        gameRunner.run();

    }
}