package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("-_-_-_-_MENU_-_-_-_-");
        System.out.println("1. PLAY NORMAL MODE");
        System.out.println("2.CREDITS ");
        System.out.println("3. EXIT");
        int option = teclado.nextInt();

        while (option != 3) {
            switch (option) {
                case 1:
                    Game match = new Game("normal");
                    System.out.println("Here we go! :) ");
                    System.out.println();
                    match.panelCreator();
                    match.menu();
                    break;

                case 2:
                    System.out.println("Game created by: https://github.com/WorkPedroCampelo ");
                    System.out.println("Thanks for playing! :)");
                    break;

                case 3:
                    System.out.println("There still mines out there! why are u leaving us! :( ");
                    break;

                default:
                    System.out.println("Not a valid value");
                    break;
            }
        }

    }
}