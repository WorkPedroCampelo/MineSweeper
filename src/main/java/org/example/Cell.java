package org.example;

public class Cell {

    public Cell(boolean withMine, char state, int column, int row) {
        this.withMine = withMine;
        this.state = state;
        this.column = column;
        this.row = row;
    }



    boolean withMine;
    char state;//X:covered, C:clear, P:marked, M:MineShowed
    int column;
    int row;

    public void setWithMine(boolean withMine) {
        this.withMine = withMine;
    }

    public void setState(char state) {
        this.state = state;
    }

    public boolean isWithMine() {
        return withMine;
    }

    public int getState() {
        return state;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
