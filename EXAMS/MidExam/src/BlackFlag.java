import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());
        int plunderDaily = Integer.parseInt(scanner.nextLine());
        double externalPlunder = Integer.parseInt(scanner.nextLine());

        double keepPlunder = 0;

        for (int i = 1; i <= day; i++) {

            keepPlunder += plunderDaily;
            if (i % 3 == 0) {
                keepPlunder = keepPlunder + plunderDaily * 1.0 / 2;
            }
            if (i % 5 == 0) {
                keepPlunder *= 0.7;
            }
        }

        if (keepPlunder >= externalPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", keepPlunder);
        } else {
            keepPlunder = keepPlunder / externalPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", keepPlunder);
        }
    }
}
