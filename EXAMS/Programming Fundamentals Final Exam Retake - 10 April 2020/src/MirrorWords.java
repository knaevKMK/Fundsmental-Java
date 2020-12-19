import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    private static Scanner scanner = new Scanner(System.in);
    private static String regex = ("([@#])(?<word1>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1");
    private static List<String> list = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while (matcher.find()) {
            count++;
            String one = matcher.group("word1");
            String second = matcher.group("word2");
            StringBuilder temp = new StringBuilder(one).reverse();

            if (second.equals(temp.toString())) {
                list.add(one + " <=> " + second);
            }
        }
        if (count == 0) {
            printResult("No word pairs found!" + System.lineSeparator() + "No mirror words!");
        } else {
            printResult(count + " word pairs found!");
            if (list.isEmpty()) {
                printResult("No mirror words!");
            } else {
                printResult("The mirror words are:" + System.lineSeparator() + list.toString().replaceAll("[\\[\\]]", ""));
            }
        }
    }

    private static void printResult(String s) {
        System.out.println(s);
    }
}
