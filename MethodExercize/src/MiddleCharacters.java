import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        printMiddleChart(data);
    }

    private static void printMiddleChart(String input) {
        String middle = "";
        if (input.length() % 2 == 0) {
            middle = getMiddleIfLenghtIsEven(input);
        } else {
            middle = getMiddleIfLenghtIsOdd(input);
        }
        System.out.println(middle);
    }

    private static String getMiddleIfLenghtIsEven(String input) {
        return input.substring(input.length() / 2 - 1, input.length() / 2 + 1);
    }

    private static String getMiddleIfLenghtIsOdd(String input) {
        return input.substring(input.length() / 2, input.length() / 2 + 1);
    }
}
