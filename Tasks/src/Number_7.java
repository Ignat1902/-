import java.util.Scanner;

public class Number_7 {
    public static void main(String[] args) {
        System.out.println("Задание 2:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str1 =scanner.nextLine();
        System.out.println("Введенная строка: " + str1);
        System.out.println("Длина самой большой строки полиндрома: " + longPalSubstr(str1));
    }
    static void printSubStr(String str1, int l, int h) {
        System.out.println(str1.substring(l, h + 1));
    }
    static int longPalSubstr(String str1) {
        int n = str1.length();
        boolean table[][] = new boolean[n][n];
        int mLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
        int strt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str1.charAt(i) == str1.charAt(i + 1)) {
                table[i][i + 1] = true;
                strt = i;
                mLength = 2;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str1.charAt(i) == str1.charAt(j)) {
                    table[i][j] = true;
                    if (k > mLength) {
                        strt = i;
                        mLength = k;
                    }
                }
            }
        }
        System.out.print("Наибольшая строка полиндром в ввведенной строке: ");
        printSubStr(str1, strt, strt + mLength - 1);
        return mLength;
    }
}
