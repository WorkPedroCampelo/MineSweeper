package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("-_-_-_-_MENU_-_-_-_-");
        System.out.println("1. PLAY EASY MODE");
        System.out.println("2. EXIT");
        int option = 1;//teclado.nextInt();

        switch (option) {
            case 1:
                Game easy = new Game("easy");
                System.out.println("Here we go! :) ");
                easy.menu();
                break;

            case 2:
                System.out.println("Byee! :)");
                break;

            default:
                System.out.println("Not a valid value");
                break;
        }


    }
}