import java.net.DatagramPacket;
import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double priceForheadset = Double.parseDouble(scanner.nextLine());
        double priceFormouse = Double.parseDouble(scanner.nextLine());
        double priceForkeyboard = Double.parseDouble(scanner.nextLine());
        double priceFordisplay = Double.parseDouble(scanner.nextLine());
        int keyboard = 0;
        int mouse = 0;
        int headset = 0;
        int display = 0;
        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headset++;
            }
            if (i % 3 == 0) {
                mouse++;
            }
            if (i % 6 == 0) {
                keyboard++;
                if (keyboard % 2 == 0 && keyboard > 0) {
                    display++;
                }
            }
        }
        double order = mouse * priceFormouse + headset * priceForheadset + keyboard * priceForkeyboard + display * priceFordisplay;
        System.out.printf("Rage expenses: %.2f lv.",order );

    }
}
