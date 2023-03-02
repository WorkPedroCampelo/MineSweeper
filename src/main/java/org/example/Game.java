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

        //easyPannel.createUserPanel();
        //easyPannel.showUserPannel();




        if (!pannelCreated){
            easyPannel.createBackPanel();
            pannelCreated=true;
        }
        System.out.println(easyPannel.showBackPanel());


        System.out.println("\n1. Open a cell");
        System.out.println("2. Mark a cell");
        System.out.println("3. Exit");
        int optionMenu = teclado.nextInt();
        switch (optionMenu) {
            case 1->{
                    System.out.println("Opening a cell");
                //openCell();
            }
            case 2->{
                    System.out.println("Marking a cell");
                //markCell();
                }
            default -> {
                System.out.println("Not a valid value");
            }

        }

    }






}
