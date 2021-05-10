package com.company;

import java.util.Scanner;
import java.util.Stack;

public class towers {
    public static void main(String[] args) {
        Stack A = new Stack();
        Stack B = new Stack();
        Stack C = new Stack();
        int N = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        N = sc.nextInt();
        for (int i = N; i > 0; i--) {
            A.add(i);
        }
        swap(A,B,C,N);
        System.out.println("Ответ:");
        System.out.println(C);
    }
    public static void swap (Stack a, Stack b, Stack c,int n) {
        if (n == 1) {
            c.add(a.pop());

        } else {
            swap(a, c, b, n - 1);
            c.add(a.pop());
            swap(b, a, c, n - 1);
        }
    }
}
