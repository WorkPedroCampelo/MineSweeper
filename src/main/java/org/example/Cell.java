package org.example;

public class Cell {

    public Cell(boolean withMine, int state, int column, int row) {
        this.withMine = withMine;
        this.state = state;
        this.column = column;
        this.row = row;
    }
    public Cell(int column, int row) {
        this.column = column;
        this.row = row;

    }


    boolean withMine;
    int state;//1:covered, 2:uncovered, 3:marked
    int column;
    int row;








}
