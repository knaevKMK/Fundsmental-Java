import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        printResult(first, second, third);
    }

    private static void printResult(int a, int b, int c) {
        int result = getSum(a, b) - c;
        System.out.println(result);
    }

    private static int getSum(int a, int b) {
        return a + b;
    }
}
