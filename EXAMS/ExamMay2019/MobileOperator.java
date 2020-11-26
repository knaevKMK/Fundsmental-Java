import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String time = scanner.nextLine();
        String type = scanner.nextLine();
        String net = scanner.nextLine();
        int month = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double netPrice = 0;
        switch (type) {
            case "Small":
                if (time.equals("one")) {
                    price = 9.98;
                } else if (time.equals("two")) {
                    price = 8.58;
                }
                break;
            case "Middle":
                if (time.equals("one")) {
                    price = 18.99;
                } else if (time.equals("two")) {
                    price = 17.09;
                }
                break;
            case "Large":
                if (time.equals("one")) {
                    price = 25.98;
                } else if (time.equals("two")) {
                    price = 23.59;
                }
                break;
            case "ExtraLarge":
                if (time.equals("one")) {
                    price = 35.99;
                } else if (time.equals("two")) {
                    price = 31.79;
                }
                break;
        }
        if (net.equals("yes")) {
            if (price > 30) {
                netPrice = 3.85;
            } else if (price > 10) {
                netPrice = 4.35;
            } else {
                netPrice = 5.5;
            }
        }

        price = (price+netPrice)*month;


        if (time.equals("two")) {
            price *= 0.9625;
        }
        System.out.printf("%.2f lv.", price);
    }
}
