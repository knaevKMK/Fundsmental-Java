import java.util.Scanner;

public class Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("Midnight")) {
            boolean flag = false;
            double sum = 0;
            for (int i = 1; i <= 6; i++) {
                int score = Integer.parseInt(scanner.nextLine());
                if (score < 0) {
                    System.out.printf("%s was cheating!%n", input);
                    flag = true;
                    break;
                }
                sum += score;
            }
            sum = Math.floor((sum / 600) * 100);
            double ocenka = sum * 0.06;
            if (!flag) {
                if (ocenka >= 5) {
                    System.out.printf("===================%n|   CERTIFICATE   |%n|    %.2f/6.00    |%n===================%nIssued to %s%n", ocenka, input);
                } else if (ocenka >= 3) {
                    System.out.printf("%s - %.2f%n", input, ocenka);
                } else {
                    System.out.printf("%s - 2.00%n", input);
                }
            }
            input = scanner.nextLine();
        }

    }
}
