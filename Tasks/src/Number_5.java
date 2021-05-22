import java.util.Arrays;
import java.util.Scanner;

public class Number_5 {
    public static void main(String[] args) {
        Number_5 s = new Number_5();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество стопок с монетами");
        int z=scanner.nextInt();
        System.out.println("Введите количество монет");
        int[] piles = new int[z];
        for (int i = 0; i < z; i++){
            piles[i] = scanner.nextInt();
        }
        s.max_coins(piles);
    }
    public void max_coins(int[] piles){
        Arrays.sort(piles);
        int sum = 0;
        int i =piles.length - 2;
        int j = 0;
        while(j++ < piles.length / 3){
            sum += piles[i];
             i -=2;
        }
        System.out.println(sum);
    }
}
