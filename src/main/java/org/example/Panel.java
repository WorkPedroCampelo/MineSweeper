package org.example;

import java.util.Arrays;
import java.util.Random;

public class Panel {
    Cell backPanel[][]=new Cell[5][5];
    static Random random= new Random();

    public Panel() {
    }




    public void createBackPanel(){
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
               backPanel[i][j]=(new Cell(false,1, i, j, 'X'));
            }
        }
        setMinesOnCells();

    }
    public String showBackPanel() {
        String panel="";
        for (int i = 0; i < 5; i++) {
            panel=panel + "\n";
            for (int j = 0; j < 5; j++) {
                panel=panel + backPanel[i][j].getSymbol() + "\t";
            }
        }
        return panel;
    }


    public void setMinesOnCells() {
        for (int i = 0; i < 5; i++) {
            backPanel[random.nextInt(5)][random.nextInt(5)].setWithMine(true);
        }
        int casa = random.nextInt(4);

    }







}
