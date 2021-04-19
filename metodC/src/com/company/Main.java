package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main( String args[] )
    {
        HashTable table = new HashTable(7);
        try
        {
            File file = new File("C:\\Users\\Игнатиks\\Desktop\\metodC\\src\\com\\company\\input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                table.addElement(scanner.next());
            }
            scanner.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("Введите искомое слово: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        table.printHashTable();
        if(table.findElement(word))
        {
            System.out.print("Такое слово есть. " + "Его Хэш: " + table.hashFunc(word));
        }
        else
            System.out.print("Такого слова нету.");

    }
}

