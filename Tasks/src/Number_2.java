import java.util.Arrays;
import java.util.Scanner;

public class Number_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int z=scanner.nextInt();
        int[] int_nums = new int[z];
        for (int i=0;i<z;i++){
            int_nums[i] = scanner.nextInt();
        }
        System.out.println(max_digit(int_nums));
    }
    public static String max_digit(int[] int_nums){
        String str = "";
        int k = 0;
        for (int i= 0; i < int_nums.length; i++){
            for (int j = 1; j < int_nums.length-i; j++) {
                String x = Integer.toString(int_nums[j-1])+Integer.toString(int_nums[j]);
                String y = Integer.toString(int_nums[j])+Integer.toString(int_nums[j-1]);
                if (x.compareTo(y)<0) {
                    k=int_nums[j];int_nums[j]=int_nums[j-1];int_nums[j-1]=k;
                }
            }
        }
        for (int item:int_nums) {
            str+=Integer.toString(item);
        }
        return str;
    }
}
