import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    private static Scanner scanner = new Scanner(System.in);
    private static Pattern pattern = Pattern.compile("@#+(?<code>[A-Z][A-Za-z\\d]{4,}[A-Z])@#+");



    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Matcher  matcher = pattern.matcher(scanner.nextLine());
            if (matcher.find()) {
                String temp = matcher.group("code");
                printResult("Product group: " + getGroup(temp));
            } else {
                printResult("Invalid barcode");
            }
        }
    }

    private static String getGroup(String temp) {
        Pattern digitPattern = Pattern.compile("(?<digit>\\d)");
        Matcher digitMatcher = digitPattern.matcher(temp);
        StringBuilder result = new StringBuilder();
        while (digitMatcher.find()) {
            result.append(digitMatcher.group("digit"));
        }
        if (result.length() == 1) {
            return "0";
        }
        if (result.length() > 1) {
            return result.toString();
        }

        return "00";
    }

    private static void printResult(String s) {
        System.out.println(s);
    }
}
