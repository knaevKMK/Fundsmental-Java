import java.util.Arrays;
import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            input = input.replace("-", "");
            int[] n = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
            System.out.println(isPalindrom(n));
            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrom(int[] n) {
        boolean valid = false;
        int countSame = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = n.length - 1 - i; j >= n.length - 1 - i; j--) {
                if (n[i] == n[j]) {
                    countSame++;
                }
            }
        }
        if (countSame == n.length) {
            valid = true;
        }
        return valid;
    }
}
