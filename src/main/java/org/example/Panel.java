package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Panel {


    private Scanner teclado;
    private int minesSetByUser = 0;
    private Cell backPanel[][];
    private Random random;
    static boolean alive = true;

    public Panel() {
        random = new Random();
        teclado = new Scanner(System.in);
    }


    public boolean isAlive() {
        return alive;
    }

    public void setRowsAndColumns() {
        System.out.println("Please input the number of rows");
        int rowsSelectedByUser = teclado.nextInt();
        System.out.println("Please input the number of columns");
        int columnsSelectedByUser = teclado.nextInt();
        backPanel = new Cell[rowsSelectedByUser][columnsSelectedByUser];

    }

    public void setAlive(boolean alive) {
        Panel.alive = alive;
    }


    public void createBackPanel() {
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                backPanel[i][j] = (new Cell(false, 'X', i, j));
            }
        }
        setMinesOnCells();

    }

    public String showBackPanel() {
        String panel = "";

        for (int i = 0; i < backPanel.length; i++) {
            panel = panel + "\n" + i + "\t";
            for (int j = 0; j < backPanel[i].length; j++) {

                panel = panel + " " + (backPanel[i][j].getState()) + "\t";
                if (backPanel[i][j].getState()=='M'){
                    backPanel[i][j].setWithMine(true);
                }
            }
        }
        panel += "\n\n";
        int k = 0;

        if (backPanel.length < backPanel[k].length) {
            do {
                panel = panel + "\t " + k;
                k++;
            } while (k < backPanel[0].length);

        } else {
            do {
                panel = panel + "\t " + k;
                k++;
            } while (k < backPanel[k - 1].length);
        }

        return panel;
    }


    public void setNumberOfMines() {
        System.out.println("Please input the number of mines u want to set on the field");
        minesSetByUser = teclado.nextInt();
        if (minesSetByUser > backPanel.length * backPanel[0].length) {
            System.out.println("Number of mines is higher than the number of cells");
            setNumberOfMines();
        }

    }
    public int askXCords(){
        System.out.print("x cords: ");
        int xCordsTakenByUser = teclado.nextInt();
        return xCordsTakenByUser;
    }
    public int askYCords(){
        System.out.print("y cords: ");
        int yCordsTakenByUser = teclado.nextInt();
        return yCordsTakenByUser;
    }

    public int getMinesSetByUser() {
        return minesSetByUser;
    }

    public void setMinesOnCells() {


        for (int countMinesSet = 0; countMinesSet < minesSetByUser; countMinesSet++) {
            int r1 = random.nextInt(backPanel.length);
            int r2 = random.nextInt(backPanel[r1].length);


            while (backPanel[r1][r2].isWithMine()) {
                r1 = random.nextInt(backPanel.length);
                r2 = random.nextInt(backPanel[r1].length);
            }

            backPanel[r1][r2].setWithMine(true);
        }
    }


    public void openCell(Cell cellToOpen) {
        System.out.println("Which cell u wanna open?");
        int xCordsTakenByUser = cellToOpen.getRow();
        int yCordsTakenByUser = cellToOpen.getColumn();

        
        if (!cellToOpen.isWithMine()) {
            String temp= String.valueOf(touchingMines(cellToOpen)); //Usado para convertir el int en char
            cellToOpen.setState( temp.charAt(0));

            if (cellToOpen.getState()!=' '){
                cellToOpen.setState(' ');
                if (touchingMines(cellToOpen)==0){
                    for (int i = 0; i < getTouchingCells(cellToOpen).size() ; i++) {
                        if (cellToOpen.getState()=='X'){
                            openCell(getTouchingCells(cellToOpen).get(i));
                        }
                    }
                }
            }
            System.out.println("Nice one soldier, you cleared the area, keep it like that");

        }  else {
            System.out.println("BIG EXPLOSION*\n\nOh no! \nSoldier down!!");
            alive = false;
            showAllMines();
            System.out.println(showBackPanel());
        }

    }



    private ArrayList<Cell> getTouchingCells(Cell mainCell) {
        ArrayList touchingCells = new ArrayList<>();
        int row = mainCell.getRow();
        int column = mainCell.getColumn();
        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < backPanel.length) {
                for (int j = column - 1; j <= column + 1; j++) {
                    if (j >= 0 && j < backPanel[i].length && !(i == row && j == column)) {
                        touchingCells.add(backPanel[i][j]);
                    }
                }
            }
        }
        return touchingCells;
    }




    public int touchingMines(Cell mainCell) {
        int counterTouchingMines = 0;
        ArrayList<Cell> touchingCells = getTouchingCells(mainCell);
        for (int i = 0; i < touchingCells.size(); i++) {
            if (touchingCells.get(i).isWithMine()) {
                counterTouchingMines++;
            }
        }
        return counterTouchingMines;
    }




    public void markCell() {
        System.out.println("Which cell u wanna mark?");
        System.out.print("x cords: ");
        int xCordsTakenByUser = teclado.nextInt();
        System.out.print("y cords: ");
        int yCordsTakenByUser = teclado.nextInt();
        System.out.println("Area marked with a flag! ");
        backPanel[xCordsTakenByUser][yCordsTakenByUser].setState('P');
    }

    public void unMarkCell() {
        System.out.println("Which cell u wanna unmark?");
        System.out.print("x cords: ");
        int xCordsTakenByUser = teclado.nextInt();
        System.out.print("y cords: ");
        int yCordsTakenByUser = teclado.nextInt();
        if (backPanel[xCordsTakenByUser][yCordsTakenByUser].getState() == 'P') {
            backPanel[xCordsTakenByUser][yCordsTakenByUser].setState('X');
        } else {
            System.out.println("There are no flags on this cell soldier");
        }
    }


    public int verifyCellsWithoutMinesLeft() {
        int cellsWithoutMinesLeft = 0;
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (backPanel[i][j].isWithMine()) {
                    cellsWithoutMinesLeft++;

                }
            }
        }
        return cellsWithoutMinesLeft;
    }

    public void showAllMines() {
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (backPanel[i][j].isWithMine()) {
                    backPanel[i][j].setState('M');
                }
            }

        }
    }

    public void openAllCellsExceptMinedOnes() {
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (!backPanel[i][j].isWithMine()) {
                    backPanel[i][j].setState(' ');
                }
            }

        }
    }

    public boolean winChecker() {
        boolean winner = false;
        int counter = 0;
        for (int i = 0; i < backPanel.length; i++) {
            for (int j = 0; j < backPanel[i].length; j++) {
                if (backPanel[i][j].getState() == ' ') {
                    counter++;
                }
            }
        }
        if (backPanel.length * backPanel[0].length - getMinesSetByUser() == counter) {
            winner = true;
        }

        if (winner == true) {
            System.out.println("YOU WON!, CONGRATS");
        }
        return winner;
    }

    /*public void checkCloseCells(){ //TODO
        if (backPanel) {

        }
    }
*/


}
