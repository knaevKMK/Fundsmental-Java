import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double funds = Double.parseDouble(scanner.nextLine());
        double fuel = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();

        double order = fuel * 2.1 + 100;
        switch (day) {
            case "Saturday":
                order *= 0.9;
                break;
            case "Sunday":
                order *= 0.8;
                break;
            default:
                break;
        }
        double diff = Math.abs(order - funds);
        if (order <= funds) {
            System.out.printf("Safari time! Money left: %.2f lv.", diff);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", diff);

        }
    }
}
