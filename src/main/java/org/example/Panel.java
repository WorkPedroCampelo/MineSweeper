package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Panel {


    static Scanner teclado=new Scanner(System.in);
    static int minesSetByUser=0;
    Cell backPanel[][];
    static Random random= new Random();

    public Panel() {
    }

    static boolean alive=true;

    public boolean isAlive() {
        return alive;
    }
    public void setRowsAndColumns(){
        System.out.println("Please input the number of rows");
        int rowsSelectedByUser= teclado.nextInt();
        System.out.println("Please input the number of columns");
        int columnsSelectedByUser= teclado.nextInt();
        backPanel=new Cell[rowsSelectedByUser][columnsSelectedByUser];

    }

    public  void setAlive(boolean alive) {
        Panel.alive = alive;
    }



    public void createBackPanel(){
        for (int i = 0; i < backPanel.length; i++) {

            for (int j = 0; j < backPanel[i].length; j++) {
               backPanel[i][j]=(new Cell(false,'X', i, j));
            }
        }
        setMinesOnCells();

    }
    public String showBackPanel() {
        String panel="";

        for (int i = 0; i < backPanel.length; i++) {

            panel=panel + "\n" + i + "\t";
            for (int j = 0; j < backPanel[i].length; j++) {

                panel=panel +" "+((char) backPanel[i][j].getState()) + "\t";


            }

        }
        panel+="\n\n";
        int k=0;

        if (backPanel.length< backPanel[k].length) {
            do {
                panel=panel+"\t " + k;
                k++;
            }while(k < backPanel[0].length);

        }else {
            do {
                panel = panel + "\t " + k;
                k++;
            } while (k < backPanel[k - 1].length);
        }

        return panel;
    }


    public void setMinesOnCells() {
        int countMinesSet=0;
        for (int i = 0; countMinesSet < minesSetByUser ; i++) {

            countMinesSet++;
            if (i+1== backPanel[i].length) {
                i=0;

            }
            backPanel[random.nextInt(backPanel.length)][random.nextInt(backPanel[i].length)].setWithMine(true); // TODO crear un bucle en el que compruebe si hay ya una mina en esa celda, si es el caso poner otro numero aleatorio hast aque encuentre una casilla sin mina.  TAMBIEN tener en cuenta, que esto generará un bucle infinito en caso de que se pongan más minas de las posibles para la matriz, es decir, hay que limitar el numero de minas a rowsSetByUser * columnsSetByUser
        }
    }

    public void setNumberOfMines(){
        System.out.println("Please input the number of mines u want to set on the field");
        minesSetByUser=teclado.nextInt();
    }


    public void openCell(){

        System.out.println("Which cell u wanna open?");
        System.out.print("x cords: ");
        int xCordsTakenByUser= teclado.nextInt();
        System.out.print("y cords: ");
        int yCordsTakenByUser= teclado.nextInt();

        if (!backPanel[xCordsTakenByUser][yCordsTakenByUser].isWithMine()){
            System.out.println("Nice one soldier, you cleared the area, keep it like that");
            backPanel[xCordsTakenByUser][yCordsTakenByUser].setState(' ');


        }else {
            System.out.println("BIG EXPLOSION*\n\nOh no! \nSoldier down!!");
            alive=false;
        }

    }

    public void markCell(){
        System.out.println("Which cell u wanna mark?");
        System.out.print("x cords: ");
        int xCordsTakenByUser= teclado.nextInt();
        System.out.print("y cords: ");
        int yCordsTakenByUser= teclado.nextInt();
        System.out.println("Area marked with a flag! ");
        backPanel[xCordsTakenByUser][yCordsTakenByUser].setState('P');
    }

    public int verifyCellsWithoutMinesLeft(){
        int cellsWithoutMinesLeft=0;
        for (int i = 0; i < backPanel.length ; i++) {
            for (int j = 0; j < backPanel[i].length ; j++) {
                if (backPanel[i][j].isWithMine()){
                    cellsWithoutMinesLeft++;

                }

            }

        }
        return cellsWithoutMinesLeft;
    }

    public void showAllMines(){
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (backPanel[i][j].isWithMine()) {
                    backPanel[i][j].setState('M');
                }
            }

        }
    }

    /*public void checkCloseCells(){ //TODO
        if (backPanel) {

        }
    }
*/





}
