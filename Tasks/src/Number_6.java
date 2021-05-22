import java.util.Scanner;

public class Number_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Задание 1:");
        System.out.println("Введите первую строку");
        String s1 = in.nextLine();
        System.out.println("Введите вторую строку");
        String s2 = in.nextLine();

        System.out.println("Результат: " + checkIfCanBreak(s1,s2));
    }
    public static boolean checkIfCanBreak(String s1, String s2) {
        int []arr1=new int[26];
        int []arr2=new int[26];

        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i++){
            arr2[s2.charAt(i)-'a']++;
        }

        int count1=0;
        int count2=0;
        int greater=0;
        int smaller=0;

        for(int i=0;i<26;i++){
            count1+=arr1[i];
            count2+=arr2[i];

            if(count2>count1){
                smaller++;
            }else if(count1>count2){
                greater++;
            }
            if(smaller>0 && greater>0)
                return false;
        }
        return true;
    }
}
