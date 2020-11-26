import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        printIsValid(password);
    }

    private static void printIsValid(String input) {
        if (betweenSixAndTenCh(input) && consistLetterAndDigits(input) && leastTwoDigits(input)) {
            System.out.println("Password is valid");
        } else {
            if (!betweenSixAndTenCh(input)) {
                System.out.println("Password must be between 6 and 10 characters");
            }
            if ((!consistLetterAndDigits(input))) {
                System.out.println("Password must consist only of letters and digits");
            }
            if (!leastTwoDigits(input)) {
                System.out.println("Password must have at least 2 digits");
            }
        }
    }

    private static boolean betweenSixAndTenCh(String input) {
        boolean answer = false;
        if (input.length() >= 6 && input.length() <= 10) {
            answer = true;
        }
        return answer;
    }

    private static boolean consistLetterAndDigits(String input) {

        boolean answer = false;
        int countvalid = 0;
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                countvalid++;
            } else {
                break;
            }
        }
        if (countvalid == input.length()) {
            answer = true;
        }
        return answer;
    }

    private static boolean leastTwoDigits(String input) {
        boolean answer = false;
        int countDigit = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9') {
                countDigit++;
            }
            if (countDigit >= 2) {
                answer = true;
                break;
            }
        }
        return answer;
    }


}
