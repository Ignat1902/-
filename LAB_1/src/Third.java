import java.util.Scanner;
public class Third
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m1 = sc.nextLine();
        String n1 = sc.nextLine();
        String min_lim1 = sc.nextLine();
        String max_lim1 = sc.nextLine();
        if (n1.equals(""))
            n1 = "50";
        if (m1.equals(""))
            m1 = "50";
        if (min_lim1.equals(""))
            min_lim1 = "-250";
        if (max_lim1.equals(""))
            max_lim1 = "1013";
        int n = Integer.parseInt(n1);
        int m = Integer.parseInt(m1);
        int min_lim = Integer.parseInt(min_lim1);
        int max_lim = Integer.parseInt(max_lim1);
        int[][] arr = new int[n][m];
        int max = 0, index = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) ((Math.random() * (max_lim - min_lim)) + min_lim);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        Third f = new Third();
        int[][] rez = f.Z3(arr,n,m);
        System.out.println("------------------------------------------------");
        for (int i=0;i<n;i++){
            System.out.print("\n");
            for (int j=0;j<n;j++){
                System.out.print(rez[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] Z3(int[][] a,int n,int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sort(a,i,j);
            }
        }
        return a;
    }

    public static void sort(int [][] a, int i, int j){

        if (i==0 || j==0){
        }
        else{
            if(a[i][j]<a[i-1][j-1]){
                int k = a[i][j];
                a[i][j]=a[i-1][j-1];
                a[i-1][j-1]=k;
            }
            sort(a,i-1,j-1);
        }
    }

}