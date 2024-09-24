package com.traneeSE.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner  {
//    SuperContraGame game;
//
//    public GameRunner(MarioGame game) {
//        this.game = game;
//    }
//its tight coupled  so we have to write the logic again
//private   SuperContraGame game;
//
//    public GameRunner(SuperContraGame game) {
//        this.game = game;
//    }
    private  GamingConsole game;
    public GameRunner(@Qualifier("supperCountraGameQualifier")
                      GamingConsole game){
        this.game=game;
    }
//by using interface we make it loosely coupled
    public void run() {
        System.out.println("gaming running" + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
