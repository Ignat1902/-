package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class boolean_expression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Игнатиks\\Desktop\\boolEx.txt")));
        Stack st = new Stack();
        Stack num = new Stack();
        Stack letter = new Stack();
        Stack preanswer = new Stack();
        int i = 0;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator = st.iterator();
        while (iterator.hasNext()) {
            char r=(char) iterator.next();
            if(Character.isDigit(r)){
                if (r=='0')
                    num.push(false);
                else
                    num.push(true);
            }
        }
        Iterator iterator1 = st.iterator();
        while (iterator1.hasNext()) {
            char r=(char) iterator1.next();
            if(Character.isAlphabetic(r)){
                letter.push(r);
            }
        }
        while (preanswer.size()!=6) {
            char s =(char) letter.pop();
            switch (s) {
                case ('O'):
                    boolean num1 = (boolean) num.pop();
                    boolean num2 = (boolean) num.pop();
                    preanswer.add(num1 || num2);
                    break;
                case ('X'):
                    boolean num3 = (boolean) num.pop();
                    boolean num4 = (boolean) num.pop();
                    if (num3 != num4) {
                        preanswer.add(true);
                    } else {
                        preanswer.add(false);
                    }
                    break;
                case ('A'):
                    boolean num5 = (boolean) num.pop();
                    boolean num6 = (boolean) num.pop();
                    preanswer.add(num5 && num6);
                    break;
                case ('N'):
                    boolean num7 = (boolean) num.pop();
                    if (num7 == true) {
                        preanswer.add(false);
                    } else {
                        preanswer.add(true);
                    }
                    break;
                case ('F'):
                    preanswer.add(false);
                    break;
                case ('T'):
                    preanswer.add(true);
                    break;
            }

        }
        Iterator iterator2 = preanswer.iterator();
        boolean answer=false;
        while (iterator2.hasNext()) {
            if ((boolean)iterator2.next() == true){
                answer = true;
            }
        }
        System.out.println("Лв = " + answer);
    }
}
