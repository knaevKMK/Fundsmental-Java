import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coin = scanner.nextLine();
        double order = 0;
        while (!"Start".equals(coin)) {
            double value = Double.parseDouble(coin);
            if (value!=0.1 && value!=0.2 && value!=0.5 && value!=1 && value!=2) {
                System.out.printf("Cannot accept %.2f%n", Double.parseDouble(coin));
                coin = scanner.nextLine();
                continue;
            }
            order += value;
            coin = scanner.nextLine();
        }

        String item = scanner.nextLine();
        while (!"End".equals(item)) {
            double value = 0.0;
            switch (item) {
                case "Nuts":
                    value = 2.0;
                    break;
                case "Water":
                    value = 0.7;
                    break;
                case "Crisps":
                    value = 1.5;
                    break;
                case "Soda":
                    value = 0.8;
                    break;
                case "Coke":
                    value = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    item = scanner.nextLine();
                    continue;
            }
            if (order - value < 0) {
                System.out.println("Sorry, not enough money");
                item = scanner.nextLine();
                continue;
            }
            order -= value;
            System.out.println("Purchased " + item);
            if (order == 0) {
                break;
            }
            item = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", order);
    }
}
