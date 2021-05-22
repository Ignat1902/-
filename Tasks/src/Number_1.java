import java.util.Scanner;

public class Number_1 {
    public static void main(String[] args) {
        Number_1 s = new Number_1();
        s.Z1();
    }
    public void Z1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] +" ");
        }
        System.out.print("\n");
        maxPerimeter(arr, n);
    }
    static void maxPerimeter (int arr[], int n) {
        int maxi = 0;                        // инициализируем максимальный периметр как 0.

        for (int i = 0; i < n - 2; i++)      // подбираем 3 разных элемента
        {                                   // из массива
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];
                    if (a < b + c && b < c + a && c < a + b)         //проверяем, a, b, c образуют треуг. или нет
                    {
                        maxi = Math.max(maxi, a + b + c);          // если он образует треугольник
                    }                                              // затем обновляем максимум
                }
            }
        }
        if (maxi > 0)                                                // Если максимальный периметр ненулевой
            System.out.println("Maximum Perimeter is: " + maxi);
        else                                                         // иначе треугольник не строится
            System.out.println("Triangle formation is not possible.");
    }
    public void Z2(){

    }
}
