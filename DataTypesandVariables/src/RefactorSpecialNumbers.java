import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int sum = 0;
            int currentDigit = currentNum;
            boolean valid = false;

            while (currentDigit > 0) {
                sum += currentDigit % 10;
                currentDigit = currentDigit / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                valid = true;
            }
            String validS = String.valueOf(valid);
            validS = validS.substring(0, 1).toUpperCase() + validS.substring(1);

            System.out.printf("%d -> %s%n", currentNum, validS);
        }
    }
}
