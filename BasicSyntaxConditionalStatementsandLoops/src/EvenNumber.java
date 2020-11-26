import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (true) {
            if (n < 0) {
                n = n * -1;
            }
            if (n % 2 == 0) {
                System.out.println("The number is: " + n);
                break;
            } else {
                System.out.println("Please write an even number.");
                n = Integer.parseInt(scanner.nextLine());
            }

        }
    }
}
