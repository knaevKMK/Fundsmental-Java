import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensbyOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        input = input.replace("-", "");
        int[] num = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Multyply(num));

    }

    private static int Multyply(int[] n) {
        int evenSum = getEvenSum(n);
        int oddSum = getOddSum(n);
        return evenSum * oddSum;
    }

    private static int getOddSum(int[] n) {
        int oddSum = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 != 0) {
                oddSum += n[i];
            }
        }
        return oddSum;
    }

    private static int getEvenSum(int[] n) {

        int evenSum = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 2 == 0) {
                evenSum += n[i];
            }
        }
        return evenSum;
    }
}
