import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println(callResult(a, operator, b));

    }

    private static int callResult(int a, char operator, int b) {
        int result = 0;
        switch (operator) {
            case '/':
                result = divide(a, b);
                break;
            case '*':
                result = multyply(a, b);
                break;
            case '+':
                result = add(a, b);
                break;
            case '-':
                result = substract(a, b);
                break;
        }
        return result;
    }

    private static int substract(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int multyply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }


}
