package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner vvod = new Scanner(System.in);
        System.out.println("Введите строчку: ");
        String text =   vvod.next();
        System.out.println("Введите подстроку для поиска: ");
        String sample = vvod.next();
        System.out.println("Алгоритм Кнута-Морриса-Пратта");
        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));

        long start = 0;
        long stop = 0;
        Search_BM a = new Search_BM();
        ArrayList <String> names = new ArrayList<>();

        Scanner sc = new Scanner (System.in);
        System.out.println("Введите основную строку:");
        String str = sc.nextLine();
        System.out.println("Введите подстроку для поиска:");
        String template = sc.nextLine();
        names.add(str);

        start = System.nanoTime();
        int index1 = str.indexOf("ja");
        System.out.println("Мы ищем букву 'ja' в строке "+ str +". Индекс данной буквы " + index1);
        stop = System.nanoTime();
        System.out.println("IndexOf: " + (stop-start));

        a.getFirstEntry(str,template);

    }

    static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return found;
    }

    static class Search_BM{
        public int getFirstEntry(String str, String template) {
            long start = 0;
            long stop = 0;
            start = System.nanoTime();
            int sourceLen = str.length();
            int templateLen = template.length();
            if (templateLen > sourceLen) {
                return -1;
            }
            HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
            for (int i = 0; i <= 255; i++) {
                offsetTable.put((char) i, templateLen);
            }
            for (int i = 0; i < templateLen - 1; i++) {
                offsetTable.put(template.charAt(i), templateLen - i - 1);
            }
            int i = templateLen - 1;
            int j = i;
            int k = i;
            while (j >= 0 && i <= sourceLen - 1) {
                j = templateLen - 1;
                k = i;
                while (j >= 0 && str.charAt(k) == template.charAt(j)) {
                    k--;
                    j--;
                }
                i += offsetTable.get(str.charAt(i));
            }
            stop = System.nanoTime();
            System.out.println("Boyer - Mur: " + (stop-start));
            if (k >= sourceLen - templateLen) {
                return -1;
            } else {
                return k + 1;
            }
        }
    }

}