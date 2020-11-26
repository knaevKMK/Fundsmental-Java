import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int Magci = Integer.parseInt(scanner.nextLine());
        String print = "";

        for (int i = 0; i < num.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < num.length; j++) {
                sum = num[i] + num[j];
                if (sum == Magci) {
                    print = (print + num[i] + " " + num[j] + "\n");
                }
            }

        }
        System.out.println(print);
    }
}
