package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //Генерация фишек
        Pyatnashki p = new Pyatnashki();
        int [][] pole = new int[4][4];
        pole = p.genetation();
        System.out.println();
        System.out.println(Pyatnashki.number_of_riots(pole));

        Board initial = new Board(pole);
        Solver solver = new Solver(initial);
        System.out.println("Minimum number of moves = " + solver.moves());
        for (Board board : solver.solution())
            System.out.println(board);


    }
    static class Pyatnashki{
        public static int[][] genetation(){
            int[][] mas = new int[4][4];
            ArrayList<Integer> pole = new ArrayList();
            int j = 0;

            for (int i = 0; i < 16; i++) {
                pole.add(j);
                j++;
            }

            Collections.shuffle(pole);
            int x=0;

            for (int i = 0; i < 4; i++) {
                System.out.println();
                for (int k = 0; k < 4; k++) {
                    mas[i][k]=pole.get(x);
                    x++;
                }
            }

            for (int i = 0; i < 4; i++) {
                System.out.println();
                for (int k = 0; k < 4; k++) {
                    System.out.print(mas[i][k]+ " ");
                }
            }
            return mas;
        }
        public static int number_of_riots(int [][] mas){
            int number_riots = 0;
            int r = 0;
            int one = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    one = mas[i][j];
                    if (one==0){
                        r=i;
                    }
                    for (int k = j; k < 4; k++) {
                        for (int l = i; l < 3; l++) {
                            if (one>mas[k][l] && mas[k][l]!=0){
                                number_riots++;
                            }
                            if (mas[k][l]==0 || mas[k][l+1]==0){
                                r=k;
                            }
                        }
                    }
                }
            }
            return number_riots+r+1;
        }
    }
}
