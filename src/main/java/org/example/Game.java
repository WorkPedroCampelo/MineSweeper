package org.example;

import jdk.swing.interop.SwingInterOpUtils;

public class Game {
/*
    TODO add a multiplier that is connected to dificulty so u can get different ways of play without violating DRY
 */
    String difficulty;


    public Game(String difficulty) {

        this.difficulty = difficulty;
    }


    public static void menu() {

        //showUserPannel
        int optionMenu = 0;
        //show mineField//UserPanel
        System.out.println("1. Open a cell");
        System.out.println("2. Mark a cell");
        System.out.println("3. Exit");
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
