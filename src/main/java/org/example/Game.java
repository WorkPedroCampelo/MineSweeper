package org.example;

import java.util.Scanner;

public class Game {
/*
    TODO add a multiplier that is connected to difficulty so u can get different ways of play without violating DRY
 */
    String difficulty;
    static Scanner teclado=new Scanner(System.in);

    public Game(String difficulty) {
        this.difficulty = difficulty;
    }
    static boolean panelCreated =false;
    public Panel gamePanel =new Panel();
    public void panelCreator(){
        gamePanel.setRowsAndColumns();
        gamePanel.setNumberOfMines();
        gamePanel.createBackPanel();
        panelCreated =true;
    }

    public void menu() {
        while (gamePanel.isAlive() /*&& gamePanel.winChecker()*/){

            System.out.println(gamePanel.showBackPanel());


            System.out.println("\n1. Open a cell");
            System.out.println("2. Mark a cell");
            System.out.println("3. Remove a flag");
            System.out.println("4. See how many mines are left");
            System.out.println("5. Exit");
            System.out.println("DEBUG OPTIONS 6:Show all mines, 7:Open all except the ones with mines");
            int optionMenu = teclado.nextInt();
            switch (optionMenu) {
                case 1->{
                    System.out.println("Opening a cell");
                    gamePanel.openCell();
                }
                case 2->{
                    System.out.println("Marking a cell");
                    gamePanel.markCell();
                }
                case 3->{
                    System.out.println("Removing flag");

                }
                case 4->{
                    System.out.println("The minefield has " + gamePanel.verifyCellsWithoutMinesLeft() + " mines right now")  ;

                }
                case 5->{
                    System.out.println("GOOOOOOOOOOD NIGHT VIETNAM!! ");
                    gamePanel.setAlive(false);
                }
                case 6->{
                    System.out.println("GOOOOOOOOOOD NIGHT VIETNAM!! ");
                    gamePanel.showAllMines();
                }
                case 7->{
                    System.out.println("GOsh VIETNAM?? ");
                    gamePanel.openAllCellsExceptMinedOnes();
                }
                default -> {
                    System.out.println("Not a valid value");
                }

            }

        }
    }









}
