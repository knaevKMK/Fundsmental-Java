import java.util.Scanner;

public class CharstoString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        char tree = scanner.nextLine().charAt(0);
        System.out.print("" + one + two + tree);
    }
}
