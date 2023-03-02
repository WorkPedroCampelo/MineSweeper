package org.example;

public class Cell {

    public Cell(boolean withMine, int state, int column, int row, char symbol) {
        this.withMine = withMine;
        this.state = state;
        this.column = column;
        this.row = row;
        this.symbol = symbol;
    }


    char symbol;//X:covered, O:uncovered, P:marked
    boolean withMine;
    int state;//1:covered, 2:uncovered, 3:marked
    int column;
    int row;

    public void setWithMine(boolean withMine) {
        this.withMine = withMine;
    }

    public boolean isWithMine() {
        return withMine;
    }

    public char getSymbol() {
        return symbol;
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
