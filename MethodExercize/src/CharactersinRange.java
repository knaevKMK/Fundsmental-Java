import java.util.Scanner;

public class CharactersinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        if (start < end) {
            printCharBetweenStartEnd(start, end);
        } else {
            printCharBetweenStartEnd(end, start);
        }
    }

    public static void printCharBetweenStartEnd(char a, char b) {
        for (char i = ++a; i < b; i++) {
            System.out.print(i + " ");
        }
    }
}
