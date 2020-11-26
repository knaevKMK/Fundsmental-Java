import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class ExOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double order = 0;
        String read = scanner.nextLine();
        while (true) {
            if (read.equals("special") || read.equals("regular")) {
                if (order > 0) {

                    double taxes = order * 0.2;
                    double total = order + taxes;
                    if (read.equals("special")) {
                        total *= 0.9;
                    }
                    System.out.printf("Congratulations you've just bought a new computer!\n" +
                            "Price without taxes: %.2f$%n" +
                            "Taxes: %.2f$%n" +
                            "-----------%n" +
                            "Total price: %.2f$%n", order, taxes, total);
                } else {
                    System.out.println("Invalid order!");
                }

                break;
            }
            double pricePart = Double.parseDouble(read);
            if (pricePart <= 0) {
                System.out.println("Invalid price!");
            } else {
                order += pricePart;
            }
            read = scanner.nextLine();
        }


    }
}
