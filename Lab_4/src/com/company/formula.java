package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class formula {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Игнатиks\\Desktop\\func.txt")));
        Stack st = new Stack();
        Stack num = new Stack();
        Stack letter = new Stack();
        Stack answer = new Stack();
        int i = 0;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator = st.iterator();
        while (iterator.hasNext()) {
            char r=(char) iterator.next();
            if(Character.isDigit(r)){
                num.add(r);
            }
        }
        Iterator iterator2 = st.iterator();
        while (iterator2.hasNext()) {
            char r=(char) iterator2.next();
            if(Character.isAlphabetic(r)){
                letter.push(r);
            }
        }
        while (answer.size()!=1){
            char s =(char) letter.pop();
            switch (s){
                case ('M'):
                    char num1 =(char)  num.pop();
                    char num2 =(char)  num.pop();
                    if (num1>num2)
                        answer.add(num1);
                    else
                        answer.add(num2);
                    break;
                case ('N'):
                    char num3 = (char) num.pop();
                    char num4 = (char) num.pop();
                    if (num4>num3)
                        answer.add(num3);
                    else
                        answer.add(num4);
                    break;
                case ('F'):
                    char num6 = (char) num.pop();
                    answer.add(num6);
            }
        }
        System.out.println(answer);
    }
}

