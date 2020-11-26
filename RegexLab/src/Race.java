import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(",\\s+");
        Map<String, Integer> list = new LinkedHashMap<>();
        for (String s : firstLine) {
            list.putIfAbsent(s, 0);
        }
        Pattern patternLetters = Pattern.compile("[A-Za-z]");
        Pattern patternDigit = Pattern.compile("\\d");

        String race = scanner.nextLine();
      while (!"end of race".equals(race)) {
            Matcher matcherLatters = patternLetters.matcher(race);
            Matcher matcherDigits = patternDigit.matcher(race);
            String name = "";
            int distance = 0;
            while (matcherLatters.find()) {
                name += matcherLatters.group();
            }
            if (list.containsKey(name)) {
                while (matcherDigits.find()) {
                    distance += Integer.parseInt(matcherDigits.group());
                }
                distance += list.get(name);
                list.put(name, distance);
            }
            race = scanner.nextLine();
        }
      int[] place = {1};
        list.entrySet().stream()
                .sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                .limit(3)
                .forEach(e -> {
                    String sub = "st";
                    if (place[0] == 2) {
                        sub = "nd";
                    } else if (place[0] == 3) {
                        sub = "rd";
                    }
                    System.out.printf("%d%s place: %s%n", place[0]++, sub, e.getKey());

                });
    }
}
