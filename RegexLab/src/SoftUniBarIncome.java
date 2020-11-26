import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String read = scanner.nextLine();
        double totalOrder = 0.0;
        Pattern pattern = Pattern.compile(
                "%(?<name>[A-Z][a-z]+)%" +
                        "[^|$%.]*" +
                        "<(?<product>\\w+)>" +
                        "[^|$%.]*" +
                        "\\|(?<quantity>\\d+)\\|" +
                        "[^|$%.]*?" +
                        "(?<price>\\d+\\.?\\d*)\\$");
        while (!"end of shift".equals(read)) {
            Matcher matcher = pattern.matcher(read);

            double order = 0;

            if (matcher.find()) {
                String name = matcher.group("name") + ": " + matcher.group("product");
                order = Integer.parseInt(matcher.group("quantity")) * Double.parseDouble(matcher.group("price"));
                totalOrder += order;
                System.out.printf("%s - %.2f%n", name, order);
            }
            read = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalOrder);
    }
}
