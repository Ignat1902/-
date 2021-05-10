package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class turn_over {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Игнатиks\\Desktop\\turn_over.txt");
        Scanner scanner = new Scanner(file);
        Stack temp = new Stack();
        while (scanner.hasNext()) {
            temp.add(scanner.nextLine());
        }
        try (PrintWriter pw = new PrintWriter("C:\\Users\\Игнатиks\\Desktop\\turn_over1.txt")) {
            {
                for (int i=0;i<=temp.size();++i) {
                    pw.println(temp.pop());
                }
                pw.println(temp.pop());
                pw.println(temp.pop());
            }
            temp.remove(temp);
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
}
