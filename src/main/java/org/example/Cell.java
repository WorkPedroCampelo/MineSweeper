package org.example;

public class Cell {

    public Cell(boolean withMine, char state, int row, int column) {
        this.withMine = withMine;
        this.state = state;
        this.column = column;
        this.row = row;
    }

    public Cell(int row, int column) {
        this.column = column;
        this.row = row;
    }

    private boolean withMine;
    private char state;//'X':covered, '0-8':clear, 'P':marked, 'M':MineShowed
    private int column;
    private int row;

    public void setWithMine(boolean withMine) {
        this.withMine = withMine;
    }

    public void setState(char state) {
        this.state = state;
    }

    public boolean isWithMine() {
        return withMine;
    }

    public char getState() {
        return state;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
