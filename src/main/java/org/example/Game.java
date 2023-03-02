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
    static boolean pannelCreated=false;
    Panel easyPannel=new Panel();

    public void menu() {
        while (easyPannel.isAlive()){

            if (!pannelCreated){
                easyPannel.createBackPanel();
                pannelCreated=true;
            }
            System.out.println(easyPannel.showBackPanel());


            System.out.println("\n1. Open a cell");
            System.out.println("2. Mark a cell");
            System.out.println("3. Remove a flag");
            System.out.println("4. Exit");
            int optionMenu = teclado.nextInt();
            switch (optionMenu) {
                case 1->{
                    System.out.println("Opening a cell");
                    easyPannel.openCell();
                }
                case 2->{
                    System.out.println("Marking a cell");
                    //markCell();
                }
                case 3->{
                    System.out.println("Removing flag");
                }
                case 4->{
                    easyPannel.setAlive(false);
                }
                default -> {
                    System.out.println("Not a valid value");
                }

            }

        }
    }









}
