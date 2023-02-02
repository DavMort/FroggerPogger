package org.example;

import java.util.ArrayList;

public class Main {
    static Screen screen = new Screen();
    static FroggerGame froggerGame;

    static {
        try {
            froggerGame = new FroggerGame(screen);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        screen.border();


    }
}