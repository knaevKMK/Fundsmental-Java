import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder result = new StringBuilder(scanner.nextLine());
        result.reverse();
        System.out.println(result);
    }
}
