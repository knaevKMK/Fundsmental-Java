import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());

        printRsult(first, second);
    }

    private static void printRsult(double a, double b) {

        System.out.printf("%.2f", resultFactorialFirst(a) / resultFactorialSecond(b));
    }

    private static double resultFactorialSecond(double b) {
        return factorialSum(b);
    }

    private static double resultFactorialFirst(double a) {
        return factorialSum(a);
    }

    private static double factorialSum(double n) {
        double factorialSum = n;
        for (double i = n - 1; i > 0; i--) {
            factorialSum *= i;
        }
        return factorialSum;
    }
}
