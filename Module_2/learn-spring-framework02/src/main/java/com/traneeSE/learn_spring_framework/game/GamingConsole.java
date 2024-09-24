package com.traneeSE.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public interface GamingConsole {
    void up();
    void down();
    void left();
    void right();

}
