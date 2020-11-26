import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getSequens(n));
    }


    private static String getSequens(int n) {
        int[] num = new int[n];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i > 2) {
                num[i] = num[i - 1] + num[i - 2] + num[i - 3];
            } else if (i > 1) {
                num[i] = num[i - 1] + num[i - 2];
            } else {
                num[i] = num[i - 1];
            }
        }
        String print = "1";
        for (int i = 1; i < n; i++) {
            print = print + " " + String.valueOf(num[i]);
        }
        return print;
    }
}
