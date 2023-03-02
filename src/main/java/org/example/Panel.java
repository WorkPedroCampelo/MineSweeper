package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Panel {


    static Scanner teclado=new Scanner(System.in);
    Cell backPanel[][]=new Cell[5][5];
    static Random random= new Random();

    public Panel() {
    }

    static boolean alive=true;

    public boolean isAlive() {
        return alive;
    }

    public  void setAlive(boolean alive) {
        Panel.alive = alive;
    }

    public void createBackPanel(){
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
               backPanel[i][j]=(new Cell(false,'X', i, j));
            }
        }
        setMinesOnCells();

    }
    public String showBackPanel() {
        String panel="";
        int k=0;
        for (int i = 0; i < 5; i++) {

            panel=panel + "\n" + i + "\t";
            for (int j = 0; j < 5; j++) {

                panel=panel +" "+((char) backPanel[i][j].getState()) + "\t";


            }

        }
        panel+="\n\n";
        while(k<5) {
            panel=panel+"\t " + k;
            k++;
        };
        return panel;
    }


    public void setMinesOnCells() {
        for (int i = 0; i < 5; i++) {
            backPanel[random.nextInt(5)][random.nextInt(5)].setWithMine(true);
        }
        int casa = random.nextInt(4);

    }

    public void openCell(){

        System.out.println("Which cell u wanna open?");
        System.out.print("x cords: ");
        int xCordsTakenByUser= teclado.nextInt();
        System.out.print("y cords: ");
        int yCordsTakenByUser= teclado.nextInt();

        if (!backPanel[xCordsTakenByUser][yCordsTakenByUser].isWithMine()){
            System.out.println("Nice one soldier, you cleared the area, keep it like that");
            backPanel[xCordsTakenByUser][yCordsTakenByUser].setState('C');


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







}
