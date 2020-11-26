import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dobiv = Integer.parseInt(scanner.nextLine());
        int day = 0;
        long sumSpice = 0;

        while (dobiv >= 100) {
            day++;
            sumSpice += dobiv;
            sumSpice -= 26;
            dobiv -= 10;
        }
        if (day > 0) {
            sumSpice -= 26;
        }
        System.out.println(day);
        System.out.printf("%d", sumSpice);

    }
}
