import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char bigger = first > second ? first : second;
        char smaller = first < second ? first : second;

        String read = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < read.length(); i++) {
            char current = read.charAt(i);
            if (current < bigger && current > smaller) {
                sum += current;
            }
        }
        System.out.println(sum);
    }
}
