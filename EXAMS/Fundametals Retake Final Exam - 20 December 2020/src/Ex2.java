import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {
    private static Scanner scanner = new Scanner(System.in);
    private static final String bossPattern =
            "(\\|)(?<boss>[A-Z]{4,})\\1:(#)(?<title>[A-Za-z]+\\s[A-Za-z]+)\\3";

    public static void main(String[] args) {


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String read = scanner.nextLine();
            Pattern pattern = Pattern.compile(bossPattern);
            Matcher matcher = pattern.matcher(read);
            String bossName;
            String title;
            if (matcher.find()) {
                bossName = matcher.group("boss");
                title = matcher.group("title");
                printResult(String.format("%s, The %s%n>> Strength: %d%n>> Armour: %d"
                        , bossName, title, bossName.length(), title.length()));
            } else {
                printResult("Access denied!");
            }
        }
    }


    private static void printResult(String s) {
        System.out.println(s);
    }
}
