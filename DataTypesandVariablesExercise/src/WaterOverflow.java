import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total= 255;
        int line = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=line ; i++) {

            int liters = Integer.parseInt(scanner.nextLine());

            if (total<liters){
                System.out.println("Insufficient capacity!");
            } else {
                total -= liters;
            }
        }
        System.out.println(255-total);
    }
}
