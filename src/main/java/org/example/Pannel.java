package org.example;

public class Pannel {
    Cell[][] backPannel = new Cell[5][5]; //ESTO ES IMPORTANTE, GRACIAS JOEL :)

    public Pannel(Cell[][] backPannel) {
        backPannel = backPannel;

    }

    public void createPanel(){
        int j=0;

        for (int i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                backPannel[i][j]=(new Cell(i,j));

            }
        }
    }

    public void setMinesOnCells() {
        //set mines on cells
    }



}
