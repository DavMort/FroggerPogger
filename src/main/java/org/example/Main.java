package org.example;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import javax.swing.*;
import java.io.IOException;
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

    public static void main(String[] args) throws InterruptedException, IOException {
        screen.border();

    }

}