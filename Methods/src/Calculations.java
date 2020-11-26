import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String comand = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());


        switch (comand) {
            case "add":
                printAdd(a, b);
                break;
            case "multiply":
                printMultiply(a, b);
                break;
            case "subtract":
                printSubstract(a, b);
                break;
            case "divide":
                printDivide(a, b);
                break;
        }

    }

    private static void printDivide(int a, int b) {
        System.out.println(a / b);
    }

    private static void printSubstract(int a, int b) {
        System.out.println(a - b);
    }

    private static void printMultiply(int a, int b) {
        System.out.println(a * b);
    }

    private static void printAdd(int a, int b) {
        System.out.println(a + b);
    }
}
