import java.util.Scanner;

public class Multiplication20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int i = Integer.parseInt(scanner.nextLine());
        for (int j = i; j <= 10; j++) {
            System.out.printf("%d X %d = %d%n", n, j, n * j);
        }
    }
}
