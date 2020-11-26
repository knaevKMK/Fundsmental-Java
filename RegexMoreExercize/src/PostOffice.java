import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split("\\|");
        final String regexOne = "([#$%*&])(?<part>[A-Z]+)\\1";
        final String regexTwo = "(?<ascii>\\d{1,2}):(?<lentgh>\\d{2})";

        String checker = getMatch(regexOne, parts[0]);
        LinkedHashMap<Character, Integer> list = new LinkedHashMap<>();
        list = addInListFirrstChar(regexTwo, parts[1], checker);

        printResul(list, parts[2], checker);

    }

    private static void printResul(LinkedHashMap<Character, Integer> list, String part, String checker) {
        String[] words = part.split("\\s+");

        for (int i = 0; i < checker.length(); i++) {
            char check = checker.charAt(i);

            for (String word : words) {
                if ((check == word.charAt(0)) && list.get(check) + 1 == word.length()) {
                    System.out.println(word);
                }
            }
        }
    }

    private static LinkedHashMap<Character, Integer> addInListFirrstChar(String regex, String part, String checker) {
        LinkedHashMap<Character, Integer> list = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(part);
        while (matcher.find()) {
            String currentS = String.valueOf((char) Integer.parseInt(matcher.group("ascii")));
            if (checker.contains(currentS) && !list.containsKey(currentS)) {
                int length = Integer.parseInt(matcher.group("lentgh"));
                list.put(currentS.charAt(0), length);
            }
        }
        return list;
    }

    private static String getMatch(String regex, String part) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(part);
        if (matcher.find()) {
            return matcher.group("part");
        }
        return "no Match";
    }
}
