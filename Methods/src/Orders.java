import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printOrder(drink, quantity);

    }

    private static void printOrder(String drink, double result) {
        switch (drink) {
            case "coffee":
                result = prinCoffe((int) result);
                break;
            case "water":
                result = printWater((int) result);
                break;
            case "coke":
                result = printCoke((int) result);
                break;
            case "snacks":
                result = printSnaks((int) result);
                break;
        }
        System.out.printf("%.2f", result);
    }


    private static double printSnaks(double qty) {
        qty *= 2.0;
        return qty;
    }

    private static double printCoke(double qty) {
        qty *= 1.4;
        return qty;
    }

    private static double printWater(double qty) {
        qty *= 1.0;
        return qty;
    }

    private static double prinCoffe(double qty) {
        qty *= 1.5;
        return qty;
    }
}
