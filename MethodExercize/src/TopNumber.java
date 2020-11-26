import java.util.Arrays;
import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printTopNums(n);
    }

    private static void printTopNums(int n) {
        if (n < 0) {
            n *= -1;
        }
        for (int i = 1; i <= n; i++) {
            if (isDivide(i) && checkDigitOdd(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isDivide(int current) {
        boolean valid = false;
        if (sumOfDigitsOfCuurent(current) % 8 == 0) {
            valid = true;
        }
        return valid;
    }

    private static int sumOfDigitsOfCuurent(int current) {
        int[] currnetDgigits = Arrays.stream(("" + current).split("")).mapToInt(Integer::parseInt).toArray();
        int sumDigitsOfCurrent = 0;
        for (int i = 0; i < currnetDgigits.length; i++) {
            sumDigitsOfCurrent += currnetDgigits[i];
        }
        return sumDigitsOfCurrent;
    }


    public static boolean checkDigitOdd(int sum) {
        int[] digitsOfSum = Arrays.stream(("" + sum).split("")).mapToInt(Integer::parseInt).toArray();
        boolean isOdd = false;
        for (int i = 0; i < digitsOfSum.length; i++) {
            if (digitsOfSum[i] % 2 != 0) {
                isOdd = true;
                break;
            }
        }
        return isOdd;
    }
}


