import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    private static Scanner scanner = new Scanner(System.in);
    private static final String emodjiPatern = "(:{2}|\\*{2})(?<emodji>[A-Z][a-z]{2,})\\1";
    private static final String digitPatern = "\\d";
    private static final String text = scanner.nextLine();
    private static int threshold = 1;
    private static int count = 0;

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(digitPatern);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            threshold *= Integer.parseInt(matcher.group());
        }
        Pattern pattern2 = Pattern.compile(emodjiPatern);
        Matcher matcherText = pattern2.matcher(text);
        while (matcherText.find()) {
            count++;
            String emodji = matcherText.group("emodji");
            int collnes = 0;
            for (int i = 0; i < emodji.length(); i++) {
                collnes += emodji.charAt(i);
            }
            if (collnes >= threshold) {
                list.add(matcherText.group(1) + emodji + matcherText.group(1));
            }
        }
        System.out.println("Cool threshold: " + threshold);
        System.out.println(count + " emojis found in the text. The cool ones are:");
        for (String s : list) {
            System.out.println(s);
        }
    }


}
