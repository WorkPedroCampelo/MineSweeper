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
    Panel easyPanel =new Panel();

    public void menu() {
        while (easyPanel.isAlive()){

            if (!panelCreated){
                easyPanel.createBackPanel();
                panelCreated =true;
            }
            System.out.println(easyPanel.showBackPanel());


            System.out.println("\n1. Open a cell");
            System.out.println("2. Mark a cell");
            System.out.println("3. Remove a flag");
            System.out.println("4. See how many mines are left");
            System.out.println("5. Exit");
            int optionMenu = teclado.nextInt();
            switch (optionMenu) {
                case 1->{
                    System.out.println("Opening a cell");
                    easyPanel.openCell();
                }
                case 2->{
                    System.out.println("Marking a cell");
                    //markCell();
                }
                case 3->{
                    System.out.println("Removing flag");
                }
                case 4->{
                    System.out.println("The minefield has " + easyPanel.verifyCellsWithoutMinesLeft() + " mines right now")  ;

                }
                case 5->{
                    System.out.println("GOOOOOOOOOOD NIGHT VIETNAM!! ");
                    easyPanel.setAlive(false);
                }
                default -> {
                    System.out.println("Not a valid value");
                }

            }

        }
    }









}
