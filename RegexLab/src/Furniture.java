import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        double order = 0;
        System.out.println("Bought furniture:");
        while (!"Purchase".equals(read)) {
            Pattern pattern = Pattern.compile(
                    ">>(?<name>[A-Za-z]+)<<(?<price>\\d+.?\\d+?)!(?<quantyti>\\d+)");
            Matcher matcher = pattern.matcher(read);
            while (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantyti"));
                System.out.println(name);
                order = order + (price * quantity);
            }
            read = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f", order);

    }
}
