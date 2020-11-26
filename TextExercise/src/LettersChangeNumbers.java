import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] read = scanner.nextLine().split("\\s+");
        double result = 0;
        for (int i = 0; i < read.length; i++) {
            char p1 = read[i].charAt(0);
            char p2 = read[i].charAt(read[i].length() - 1);
            long num = Integer.parseInt(read[i].substring(1, read[i].length() - 1));

            double currentResult = resultFirst(p1, num);
            currentResult = resultLast(p2, currentResult);
            result += currentResult;
        }
        System.out.printf("%.2f", result);
    }

    private static double resultLast(char p2, double num) {
        if (Character.isUpperCase(p2)) {
            return num - (p2 - 64);
        } else {
            return num + (p2 - 96);
        }
    }

    private static double resultFirst(char p1, long num) {
        if (Character.isUpperCase(p1)) {
            return num * 1.0 / (p1 - 64);
        } else {
            return num * (p1 - 96);
        }
    }
}
