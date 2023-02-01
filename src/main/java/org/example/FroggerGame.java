package org.example;

import java.util.ArrayList;

public class FroggerGame {
    private int ticks = 30;
    private Screen screen;
    private ArrayList<Position> car = new ArrayList<>();
    private Position frog;
    public FroggerGame(Screen screen)  {
        this.screen = screen;
        addCars();

    }
    public void addCars() {
        car.add(new Position(33, 7));
        screen.putChar(car.get(0).col, car.get(0).row, '\u2588', Screen.GREEN, Screen.GREEN);
    }
}
