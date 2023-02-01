package org.example;

import com.googlecode.lanterna.TextColor;

import java.util.ArrayList;

public class FroggerGame {
    private int ticks = 30;
    private Screen screen;
    private ArrayList<Position> carLine1 = new ArrayList<>();
    private ArrayList<Position> carLine2 = new ArrayList<>();
    private ArrayList<Position> carLine3 = new ArrayList<>();
    private ArrayList<Position> carLine4 = new ArrayList<>();
    private ArrayList<Position> carLine5 = new ArrayList<>();
    private Position frog;

    public FroggerGame(Screen screen) {
        this.screen = screen;
        addCars();

    }

    public void addCars() {
        for (int i = 0; i < 6; i++) {
            carLine1.add(new Position(2 + (i * 13), 9));
            drawCar(carLine1, Screen.YELLOW,true);
        }
        for (int i = 0; i < 6; i++) {
            carLine2.add(new Position(4 + (i * 13), 7));
            drawCar(carLine2, Screen.RED, false);
        }
        for (int i = 0; i < 6; i++) {
            carLine3.add(new Position(6 + (i * 13), 5));
            drawCar(carLine3, Screen.GREEN, true);
        }

    }
    public void drawCar(ArrayList<Position> car, TextColor color, boolean driveLeft) {
        if (driveLeft) {
            for (Position c : car) {
                screen.putChar(c.getCol(), c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() + 1, c.getRow(), '\u2588', Screen.BLUE, Screen.BLUE);
                screen.putChar(c.getCol() + 2, c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() + 3, c.getRow(), '\u2588', color, color);
            }
        } else {
            for (Position c : car) {
                screen.putChar(c.getCol(), c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() - 1, c.getRow(), '\u2588', Screen.BLUE, Screen.BLUE);
                screen.putChar(c.getCol() - 2, c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() - 3, c.getRow(), '\u2588', color, color);
            }
        }
    }
}

