package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class cipher {
    private final static char[] DEK = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Игнатиks\\Desktop\\read.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\Игнатиks\\Desktop\\read1.txt")));

        int i = 0;
        while((i = reader.read()) != -1) {
            char ch = (char) i;
            writer.append(switchLetter(ch));
            writer.flush();
        }

        reader.close();
        writer.close();
    }

    private static char switchLetter(char ch) {
        char outchar = '0';
        for(int i = 2; i < DEK.length; i++) {
            char c = DEK[i];
            if(Character.compare(c, ch) == 0) {
                outchar = DEK[i-2];
                break;
            }
        }

        if(Character.compare(outchar, '0') == 0)
            outchar = ch;

        return outchar;
    }
}