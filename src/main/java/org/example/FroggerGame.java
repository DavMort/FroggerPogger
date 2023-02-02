package org.example;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;

public class FroggerGame {
    private int ticks = 30;
    private static Screen screen;
    private ArrayList<Position> carLine1 = new ArrayList<>();
    private ArrayList<Position> carLine2 = new ArrayList<>();
    private ArrayList<Position> carLine3 = new ArrayList<>();
    private ArrayList<Position> carLine4 = new ArrayList<>();
    private ArrayList<Position> carLine5 = new ArrayList<>();
    private ArrayList<Position> carLine6 = new ArrayList<>();
    private ArrayList<Position> carLine7 = new ArrayList<>();
    private ArrayList<Position> carLine8 = new ArrayList<>();

    private static Position frog = new Position(15,1,false);
    private Position frogPos = new Position(15,1);

    public FroggerGame(Screen screen) {
        this.screen = screen;
        addFrog();
        addCars();
    }

    //Ulfs Snake Controls

    public static boolean handleKey(KeyStroke keyStroke){
            String result = "";
            if (keyStroke == null) return false;

            KeyType kt = keyStroke.getKeyType();
            switch (kt) {
                case ArrowDown, ArrowUp, ArrowRight, ArrowLeft:
                    result = tryMove(kt);
                    break;
                default:
                    //ignore all other key!!
                    return false;
            }
            if (result.equals("Continue")) {
                return true;
            }

        /* else {
            screen.putString(10,15,result);
            screen.putString(10,17, "End of game");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // ignore
            }
            System.exit(0);
            return false;

         */
        return false;
    }

    private static String tryMove(KeyType kt)  {
        int row = frog.getRow();
        int col = frog.getCol();
        switch(kt) {
            case ArrowUp:
                row--;
                break;
            case ArrowDown:
                row++;
                break;
            case ArrowLeft:
                col--;
                break;
            case ArrowRight:
                col++;
                break;
            default:
                //ignore illegal keystrokes
                return "Continue";
        }
        moveFrog(col,row);

        return "Continue";
    }
    private static void moveFrog(int col, int row){
        //System.out.println("move" + col + " " + row);
        frog.setCol(col);
        frog.setRow(row);
        screen.putChar(frog.getCol(),frog.getRow(), '@', Screen.GREEN, Screen.BLACK);
    }

    public ArrayList<Position> getCarLine1() {
        return carLine1;
    }

    public void setCarLine1(ArrayList<Position> carLine1) {
        this.carLine1 = carLine1;
    }

    public ArrayList<Position> getCarLine2() {
        return carLine2;
    }

    public void setCarLine2(ArrayList<Position> carLine2) {
        this.carLine2 = carLine2;
    }

    public ArrayList<Position> getCarLine3() {
        return carLine3;
    }

    public void setCarLine3(ArrayList<Position> carLine3) {
        this.carLine3 = carLine3;
    }

    public ArrayList<Position> getCarLine4() {
        return carLine4;
    }

    public void setCarLine4(ArrayList<Position> carLine4) {
        this.carLine4 = carLine4;
    }

    public ArrayList<Position> getCarLine5() {
        return carLine5;
    }

    public void setCarLine5(ArrayList<Position> carLine5) {
        this.carLine5 = carLine5;
    }

    public ArrayList<Position> getCarLine6() {
        return carLine6;
    }

    public void setCarLine6(ArrayList<Position> carLine6) {
        this.carLine6 = carLine6;
    }

    public ArrayList<Position> getCarLine7() {
        return carLine7;
    }

    public void setCarLine7(ArrayList<Position> carLine7) {
        this.carLine7 = carLine7;
    }

    public ArrayList<Position> getCarLine8() {
        return carLine8;
    }

    public void setCarLine8(ArrayList<Position> carLine8) {
        this.carLine8 = carLine8;
    }

    public void addCars() {
        for (int i = 0; i < 6; i++) {
            carLine1.add(new Position(2 + (i * 13), 3, true));
            drawCar(carLine1, Screen.YELLOW);
        }
        for (int i = 0; i < 6; i++) {
            carLine2.add(new Position(4 + (i * 13), 5, false));
            drawCar(carLine2, Screen.RED);
        }
        for (int i = 0; i < 6; i++) {
            carLine3.add(new Position(6 + (i * 13), 7, false));
            drawCar(carLine3, Screen.GREEN);
        }
        for (int i = 0; i < 6; i++) {
            carLine4.add(new Position(6 + (i * 13), 9, true));
            drawCar(carLine4, Screen.RED);
        }
        for (int i = 0; i < 6; i++) {
            carLine5.add(new Position(6 + (i * 13), 13, true));
            drawCar(carLine5, Screen.WHITE);
        }
        for (int i = 0; i < 6; i++) {
            carLine6.add(new Position(6 + (i * 13), 15, false));
            drawCar(carLine6, Screen.GREEN);
        }
        for (int i = 0; i < 6; i++) {
            carLine7.add(new Position(6 + (i * 13), 17, true));
            drawCar(carLine7, Screen.YELLOW);
        }
        for (int i = 0; i < 6; i++) {
            carLine8.add(new Position(6 + (i * 13), 19, false));
            drawCar(carLine8, Screen.YELLOW);
        }

    }

    public void drawCar(ArrayList<Position> car, TextColor color) {
        for (Position c : car) {
            if (c.isDriveLeft()) {
                screen.putChar(c.getCol(), c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() + 1, c.getRow(), '\u2588', Screen.BLUE, Screen.BLUE);
                screen.putChar(c.getCol() + 2, c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() + 3, c.getRow(), '\u2588', color, color);
            } else {
                screen.putChar(c.getCol(), c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() - 1, c.getRow(), '\u2588', Screen.BLUE, Screen.BLUE);
                screen.putChar(c.getCol() - 2, c.getRow(), '\u2588', color, color);
                screen.putChar(c.getCol() - 3, c.getRow(), '\u2588', color, color);
            }
        }
    }

    public void addFrog() {
        frog.setCol(15);
        frog.setRow(1);
    screen.putChar(frog.getCol(),frog.getRow(),'@',Screen.GREEN,Screen.BLACK);
    }

    public void moveCars() {
        for (Position c : carLine3) {

        }
    }
    }



