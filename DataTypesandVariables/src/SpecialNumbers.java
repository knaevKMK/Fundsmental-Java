import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String valid = "False";
            int currentNum = i;
            int lastDigit = 0;
            int sum = 0;

            while (currentNum > 0) {
                lastDigit = currentNum % 10;
                sum += lastDigit;
                currentNum /= 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                valid = "True";
            }
            System.out.printf("%d -> %s%n", i, valid);
        }
    }
}
