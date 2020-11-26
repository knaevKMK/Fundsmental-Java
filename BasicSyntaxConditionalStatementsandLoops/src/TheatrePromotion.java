import javax.swing.*;
import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;
        switch (day) {
            case "Weekday":
                if (age <= 18 && age >= 0) {
                    price = 12;
                } else if (age>18 && age <= 64) {
                    price = 18;
                } else if (age>64 && age <= 122) {
                    price = 12;
                } else {
                    price = -1;
                }
                break;
            case "Weekend":
                if (age <= 18 && age >= 0) {
                    price = 15;
                } else if (age>18 && age <= 64) {
                    price = 20;
                } else if (age>64 && age <= 122) {
                    price = 15;
                } else {
                    price = -1;
                }
                break;
            case "Holiday":
                if (age <= 18 && age >= 0) {
                    price = 5;
                } else if (age>18 && age <= 64) {
                    price = 12;
                } else if (age>64 && age <= 122) {
                    price = 10;
                } else {
                    price = -1;
                }
                break;
            default:
                price = -1;
                break;
        }
        if (price < 0) {
            System.out.print("Error!");
        } else {
            System.out.printf("%d$", price);
        }
    }
}
