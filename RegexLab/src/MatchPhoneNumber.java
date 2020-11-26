import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern phoneNumbers = Pattern.compile("\\+359([ \\-])2\\1([\\d]{3}\\1[\\d]{4})\\b");
        Matcher matcher = phoneNumbers.matcher(line);
        List<String> pnSofia = new ArrayList<>();
        while (matcher.find()) {
            pnSofia.add(matcher.group(0));
        }
        System.out.println((pnSofia.toString().replaceAll("[\\[\\]]", "")));
    }
}
