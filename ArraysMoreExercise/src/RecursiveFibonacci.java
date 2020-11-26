import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[] num = new long[n];
        if (n >= 1 && n <= 50) {
            for (int i = 0; i < n; i++) {
                if (i >= 2) {
                    num[i] = num[i - 1] + num[i - 2];
                } else {
                    num[i] = 1;
                }
            }
            System.out.print(num[n - 1]);
        }else if(n==0){
            System.out.print(0);
        }

    }
}
