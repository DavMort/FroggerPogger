package org.example;

import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;

public class Main {
    static Screen screen = new Screen();
    static FroggerGame froggerGame = new FroggerGame(screen);
    public static void main(String[] args) throws InterruptedException {
        singleKey();
    }
    private static void singleKey() throws InterruptedException {
        KeyStroke keyStroke;
        while (true) {
            keyStroke = screen.getKeyStroke();
            FroggerGame.handleKey(keyStroke);
            Thread.sleep(5);
        }
    }
}