import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chiken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int veg = Integer.parseInt(scanner.nextLine());

        double order = chiken * 10.35 + fish * 12.4 + veg * 8.15;
        order *= 1.2;
        order += 2.5;
        System.out.printf("Total: %.2f", order);
    }
}
