package org.example;

import java.util.ArrayList;

public class FroggerGame {
    private int ticks = 30;
    private Screen screen;
    private ArrayList<Position> car = new ArrayList<>();
    private Position frog;

    public FroggerGame(Screen screen) {
        this.screen = screen;
        addCars();

    }

    public void addCars() {
        for (int i = 0; i < 6; i++) {
            car.add(new Position(2 + (i * 13), 9));
            screen.putChar(car.get(i).col, car.get(i).row, '\u2588', Screen.GREEN, Screen.GREEN);
            screen.putChar(car.get(i).col + 1, car.get(i).row, '\u2588', Screen.BLUE, Screen.GREEN);
            screen.putChar(car.get(i).col + 2, car.get(i).row, '\u2588', Screen.GREEN, Screen.GREEN);
            screen.putChar(car.get(i).col + 3, car.get(i).row, '\u2588', Screen.GREEN, Screen.GREEN);
        }
        for (int i = 0; i < 6; i++) {
            car.add(new Position(2 + (i * 13), 7));
            screen.putChar(car.get(i + 5).col, car.get(i + 5).row, '\u2588', Screen.GREEN, Screen.GREEN);
            screen.putChar(car.get(i + 5).col + 1, car.get(i + 5).row, '\u2588', Screen.BLUE, Screen.GREEN);
            screen.putChar(car.get(i + 5).col + 2, car.get(i + 5).row, '\u2588', Screen.GREEN, Screen.GREEN);
            screen.putChar(car.get(i + 5).col + 3, car.get(i + 5).row, '\u2588', Screen.GREEN, Screen.GREEN);
        }
        for (int i = 0; i < 6; i++) {
            car.add(new Position(2 + (i * 13), 5));
            screen.putChar(car.get(i).col, car.get(i).row, '\u2588', Screen.GREEN, Screen.GREEN);
            screen.putChar(car.get(i).col + 1, car.get(i).row, '\u2588', Screen.BLUE, Screen.GREEN);
            screen.putChar(car.get(i).col + 2, car.get(i).row, '\u2588', Screen.GREEN, Screen.GREEN);
            screen.putChar(car.get(i).col + 3, car.get(i).row, '\u2588', Screen.GREEN, Screen.GREEN);
        }

    }
}

