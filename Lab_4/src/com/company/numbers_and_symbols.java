package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class numbers_and_symbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Игнатиks\\Desktop\\Symbol.txt")));
        Stack st = new Stack();
        Stack s = new Stack();
        int i = 0;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator = st.iterator();
        Iterator iterator1 = st.iterator();
        Iterator iterator2 = st.iterator();
        while (iterator.hasNext()) {
            char r  = (char) iterator.next();
            if (!Character.isDigit(r) && !Character.isLetter(r)){
                s.push(r);
            }
        }
        while (iterator1.hasNext()) {
            char r  = (char) iterator1.next();
            if (Character.isLetter(r)){
                s.push(r);
            }
        }
         while (iterator2.hasNext()) {
            char r  = (char) iterator2.next();
            if (Character.isDigit(r)){
                s.push(r);
            }
        }
        System.out.println(s);
    }
}
