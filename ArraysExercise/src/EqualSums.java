import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int count = 0;
        boolean valid = false;
        for (int i = 0; i < num.length; i++) {
            int sumLeft = 0;
            int sumRgiht = 0;

            for (int j = 0; j < i; j++) {
                sumLeft += num[j];
            }
            for (int j = i + 1; j < num.length; j++) {
                sumRgiht += num[j];
            }
            if (sumLeft == sumRgiht) {
                count = i;
                valid = true;
                break;
            }
        }
        if (valid) {
            System.out.print(count);
        } else {
            System.out.println("no");
        }
    }
}
