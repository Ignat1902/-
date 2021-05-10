package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class true_formula {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Игнатиks\\Desktop\\funcTrue.txt")));
        Stack st = new Stack();
        Stack letter = new Stack();
        Stack symbols = new Stack();
        int i = 0;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator1 = st.iterator();
        while (iterator1.hasNext()) {
            char r = (char) iterator1.next();
            if (Character.isAlphabetic(r)) {
                letter.push(r);
            }
        }
        Iterator iterator2 = st.iterator();
        while (iterator2.hasNext()) {
            char r = (char) iterator2.next();
            if (!(Character.isDigit(r) || Character.isAlphabetic(r))) {
                symbols.push(r);
            }
        }
        System.out.println(letter);
        System.out.println(symbols);
        int kol = 0;
        while (symbols.size() != 0) {
            char s = (char) symbols.pop();
            switch (s) {
                case ('+'):
                case ('-'):
                    kol++;
                    break;
            }
        }
        int w = 0;
        while (letter.size() != 0) {
            char s = (char) letter.pop();
            switch (s) {
                case ('x'):
                case ('y'):
                case ('z'):
                    w++;

                    break;
            }
        }
        if (w-1 == kol)
            System.out.println("Формула имеет правильный вид");
        else
            System.out.println("Формула имеет не правильный вид");
    }
}
