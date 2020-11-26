import java.util.Scanner;

public class DWR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double c2 = 0;
        double c3 = 0;
        double c4 = 0;

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            if (value % 2 == 0) {
                c2 += 1;
            }
            if ((value % 3 == 0)) {
                c3 += 1;
            }
            if (value % 4 == 0) {
                c4 += 1;
            }
        }
        c2 = c2 / n * 100;
        c3 = c3 / n * 100;
        c4 = c4 / n * 100;
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n", c2, c3, c4);
    }
}

