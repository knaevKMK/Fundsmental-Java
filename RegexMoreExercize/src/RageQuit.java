import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        final String regex = "(?<sequens>[A-Za-z\\W_]+)" +
                "(?<repeat>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            int repeat = Integer.parseInt(matcher.group("repeat"));
            for (int i = 1; i <= repeat; i++) {
                result.append(matcher.group("sequens").toUpperCase());
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < result.length(); i++) {
            if (!list.contains((char) (result.charAt(i)))) {
                list.add((result.charAt(i)));
            }
        }
        System.out.println("Unique symbols used: " + list.size());
        System.out.println(result);
    }
}
