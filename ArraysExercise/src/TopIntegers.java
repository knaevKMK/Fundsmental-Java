import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < num.length; i++) {
            boolean valid = true;

            for (int j = i + 1; j < num.length; j++) {
                if (num[i] <= num[j]) {
                    valid=false;
                    break;
                }
            }
            if (valid)
                System.out.print(num[i] + " ");
        }
    }
}
