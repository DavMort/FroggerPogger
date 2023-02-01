package org.example;

public class Position {
    int col,row;
    boolean driveLeft;

    public int getRow() {
        return row;
    }

    public Position(int col, int row) {
        this.row = row;
        this.col = col;
    }

    public Position(int col, int row, boolean driveLeft) {
        this.col = col;
        this.row = row;
        this.driveLeft = driveLeft;
    }

    public boolean isDriveLeft() {
        return driveLeft;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
