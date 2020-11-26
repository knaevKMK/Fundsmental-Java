import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n >= 1 && n <= 60) {
            int[] preRow = new int[n];
            int[] curent = new int[n];

            for (int i = 0; i < n; i++) {

                for (int k = 0; k < i; k++) {// re=write
                    preRow[k] = curent[k];
                    if (k == i) {
                        preRow[k] = 1;
                    }
                }

                preRow[0] = 1;

                for (int j = 0; j <= i; j++) {
                    if (j > 0) {
                        curent[j] = preRow[j] + preRow[j - 1];
                    } else {
                        curent[j] = preRow[j];
                    }
                    System.out.print(curent[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
