import java.util.Scanner;

public class TShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double fund = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double order = 0;
        int count = 0;

        while (true) {
            if (input.equals("Stop")) {
                System.out.printf("You bought %d products for %.2f leva.", count, order);
                break;
            }
            count++;
            double value = Double.parseDouble(scanner.nextLine());
            if (count % 3 == 0) {
                value /= 2;
            }
            if (value > (fund - order)) {
                System.out.printf("You don't have enough money!%nYou need %.2f leva!", value - (fund - order));
                break;
            }
            order += value;
            input= scanner.nextLine();
        }
    }
}
