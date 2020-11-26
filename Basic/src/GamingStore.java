import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double funds = Double.parseDouble(scanner.nextLine());
        String read = scanner.nextLine();
        double order = 0;

        while (!"Game Time".equals(read)) {
            double price = 0.0;
            switch (read) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    read = scanner.nextLine();
                    continue;
            }

            if (price > funds) {
                System.out.println("Too Expensive");
                read = scanner.nextLine();
                continue;
            }
            order += price;
            funds -= price;
            System.out.println("Bought " + read);
            if (0.0 == funds) {
                System.out.println("Out of money!");
                break;
            }
            read = scanner.nextLine();
        }
        if (funds > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", order, funds);
        }
    }
}
