package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Panel gamePanel =new Panel();//TODO Preguntar a la profe si es necesario crear gamePanel de nuevo (está tambien en la clase Panel)

        Scanner teclado = new Scanner(System.in);
        System.out.println("-_-_-_-_MENU_-_-_-_-");
        System.out.println("1. PLAY NORMAL MODE");
        System.out.println("2. SELECT NUMBER OF ROWS AND COLUMNS");
        int option = teclado.nextInt();

        switch (option) {
            case 1:
                //gamePanel.setRowsAndColumns(); Esto se podría hacer? (solo por curiosidad)
                Game match = new Game("normal");
                System.out.println("Here we go! :) ");
                System.out.println();
                match.menu();
                break;

            case 2:
                System.out.println("Changing rows and columns");
                break;

            case 3:
                System.out.println("Byee! :)");
                break;

            default:
                System.out.println("Not a valid value");
                break;
        }


    }
}