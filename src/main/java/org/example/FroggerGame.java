package org.example;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

public class FroggerGame {
    private Screen screen;
    private ArrayList<Position> car = new ArrayList<>();
    private Position frog;

    public FroggerGame(Screen screen) throws InterruptedException {
        this.screen = screen;
        screen.border();
        addCar();
        drawCar(car, Screen.YELLOW);
        addFrog();

        while (true) {
            Thread.sleep(300);
            moveCars();
        }
    }

    public void addCar() {
        int row = 3;
        boolean driveLeft;
        for (int i = 0; i < 8; i++) {
            driveLeft = i % 2 == 0;
            for (int j = 0; j < 6; j++) {
                car.add(new Position(7 + (j * 12), row, driveLeft));
            }
            row += 2;
            if (row == 11) {
                row += 2;
            }
        }
    }
    public void drawCar(ArrayList<Position> car, TextColor color) {
            for (Position c : car) {
                if (c.isDriveLeft()) {
                    screen.putChar(c.getCol(), c.getRow(), '\u2588', color, color);
                    screen.putChar(c.getCol() + 1, c.getRow(), '\u2588', Screen.BLUE, Screen.BLUE);
                    screen.putChar(c.getCol() + 2, c.getRow(), '\u2588', color, color);
                    screen.putChar(c.getCol() + 3, c.getRow(), '\u2588', color, color);
                    screen.putChar(c.getCol() + 4, c.getRow(), '~');
                } else {
                    screen.putChar(c.getCol(), c.getRow(), '\u2588', color, color);
                    screen.putChar(c.getCol() - 1, c.getRow(), '\u2588', Screen.BLUE, Screen.BLUE);
                    screen.putChar(c.getCol() - 2, c.getRow(), '\u2588', color, color);
                    screen.putChar(c.getCol() - 3, c.getRow(), '\u2588', color, color);
                    screen.putChar(c.getCol() - 4, c.getRow(), '~');
            }
        }
    }
    public void moveCars() {
        for (Position c : car) {
            if (c.getCol() > 77) {
                for (int i = 0; i < 5; i++) {
                    screen.putChar(c.getCol() - i, c.getRow(), ' ');
                }
                c.setCol(5);

            } else if (c.getCol() < 2) {
                for (int i = 0; i < 5; i++) {
                    screen.putChar(c.getCol() + i, c.getRow(), ' ');
                }
                c.setCol(74);

            }
            if (c.isDriveLeft()) {
                screen.putChar(c.getCol() + 3, c.getRow(), ' ');
                screen.putChar(c.getCol() + 4, c.getRow(), ' ');
                c.setCol(c.getCol() - 1);
            } else {
                screen.putChar(c.getCol() - 3, c.getRow(), ' ');
                screen.putChar(c.getCol() - 4, c.getRow(), ' ');
                c.setCol(c.getCol() + 1);
            }
        }
        drawCar(car, Screen.YELLOW);
    }
    public void addFrog() {
        frog = new Position(40, 22);
        drawFrog();
    }
    public void drawFrog() {
        screen.putChar(frog.getCol(), frog.getRow(), '\u26C4', Screen.GREEN, Screen.BLACK);
    }
}

