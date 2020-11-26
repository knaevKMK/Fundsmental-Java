import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {

        String result = "";
        result = getResult(result);

        System.out.println(result);
    }

    private static String getResult(String result) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(scanner.nextLine());
            if (num[i] == 0) {
                return "zero";
            }
        }
        return positiveOrNegative(num);
    }

    private static String positiveOrNegative(int[] num) {
        int countNegative = 0;
        for (int i = 0; i < 3; i++) {
            if (num[i] < 0) {
                countNegative++;
            }
        }
        if (countNegative % 2 == 1) {
            return "negative";
        } else {
            return "positive";
        }
    }
}
