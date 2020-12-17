import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    private static Scanner scanner = new Scanner(System.in);
    private static Pattern pattern = Pattern.compile("(@[#]{1,}+)(?<code>[A-Z][A-Za-z\\d]{4,}[A-Z])(@[#]{1,}+)");

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            if (matcher.find()) {
                String temp = matcher.group("code");
                System.out.println("Product group: " + getbarCodeGroup(temp));
                continue;
            }
            System.out.println("Invalid barcode");
        }
    }

    private static String getbarCodeGroup(String temp) {
        Pattern pattern1 = Pattern.compile("(?<digit>\\d)");
        Matcher matcher1 = pattern1.matcher(temp);
        StringBuilder result = new StringBuilder();
        while (matcher1.find()) {
            result.append(matcher1.group("digit"));
        }
        if (result.length() == 1) {
            return "0";
        }
        if (result.length() > 1) {
            return result.toString();
        }
        return "00";
    }
}
