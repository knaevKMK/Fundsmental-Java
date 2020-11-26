import java.util.Scanner;

public class testA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int i = Integer.parseInt(scanner.nextLine());
        if (i > 10) {
            print(n, i);
        }
        for (int j = i; j <= 10; j++) {
            print(n, j);
        }

    }

    private static void print(int n, int i) {
        System.out.printf("%d X %d = %d%n", n, i, n * i);
    }
}
