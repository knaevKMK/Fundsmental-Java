import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double max = 1;
        String bigger = "";

        for (int i = 1; i <= n; i++) {

            String type = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * radius * radius * height;

            if (volume > max) {
                max = volume;
                bigger = type;
            }
        }
        System.out.println(bigger);
    }
}
