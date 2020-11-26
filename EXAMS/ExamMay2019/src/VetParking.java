import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        double order = 0;
        for (int i = 1; i <= day; i++) {
            double dayOrder = 0;
            double price = 0;
            for (int j = 1; j <= hours; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    price = 2.5;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    price = 1.25;
                } else {
                    price = 1;
                }
                dayOrder += price;

            }
            order += dayOrder;
            System.out.printf("Day: %d - %.2f leva%n", i, dayOrder);
        }
        System.out.printf("Total: %.2f leva", order);
    }
}
