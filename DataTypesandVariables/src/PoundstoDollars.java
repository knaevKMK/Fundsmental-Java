import java.util.Scanner;

public class PoundstoDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pound = Double.parseDouble(scanner.nextLine());;
        System.out.printf("%.3f", pound * 1.31);
    }
}
