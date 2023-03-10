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
    public void setNumberOfMines(){
        System.out.println("Please input the number of mines u want to set on the field");
        minesSetByUser=teclado.nextInt();
        if (minesSetByUser> backPanel.length*backPanel[0].length){
            System.out.println("Number of mines is higher than the number of cells");
            setNumberOfMines();
        }
    }


    public void setMinesOnCells() {


        for (int countMinesSet = 0; countMinesSet < minesSetByUser ; countMinesSet++) {
            int r1=random.nextInt(backPanel.length) ;
            int r2=random.nextInt(backPanel[r1].length) ;



            while ( backPanel[r1][r2].isWithMine()) {
                r1=random.nextInt(backPanel.length) ;
                r2=random.nextInt(backPanel[r1].length) ;
            }

            backPanel[r1][r2].setWithMine(true);
        }
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

    //TODO unmark a cell

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

    public void openAllCellsExceptMinedOnes(){
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (!backPanel[i][j].isWithMine()) {
                    backPanel[i][j].setState(' ');
                }
            }

        }
    }

   /* public boolean winChecker(){      //TODO
        boolean unMined=false;
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (!backPanel[i][j].isWithMine()) {
                    //unMined=true;

                }
            }


        }

        System.out.println("YOU WON!, CONGRATS");
        return unMined;
    }*/

    /*public void checkCloseCells(){ //TODO
        if (backPanel) {

        }
    }
*/





}
