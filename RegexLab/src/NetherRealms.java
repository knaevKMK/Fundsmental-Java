import com.sun.jdi.IntegerType;

import java.util.*;
import java.util.concurrent.TransferQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().replaceAll("\\s","").split(",");
        List<String> deamons = new ArrayList<>();
        for (String name : names) {
            int health = getHealth(name);
            double damage = getDamage(name);
            String add = String.format("%s - %d health, %.2f damage", name, health, damage);
            deamons.add(add);
        }
        deamons.stream().sorted((a1, a2) -> a1.compareTo(a2))
                .forEach(System.out::println);

    }

    private static double getDamage(String name) {
        double sum = 0;
        Pattern patternHealth = Pattern.compile("\\-?\\d+\\.?\\d*");
        Matcher matcherHealth = patternHealth.matcher(name);
        while (matcherHealth.find()) {
            sum += Double.parseDouble(matcherHealth.group());

        }

        Pattern patternDevide = Pattern.compile("[*/]");
        Matcher matcherDevide = patternDevide.matcher(name);
        List<String> deviedies = new ArrayList<>();
        while (matcherDevide.find()) {
            deviedies.add(matcherDevide.group());
        }
        for (String deviedy : deviedies) {
            if ("*".equals(deviedy)) {
                sum *= 2;
            }
            if ("/".equals(deviedy)) {
                sum /= 2;
            }
        }
        return sum;

    }

    private static int getHealth(String name) {
        int sum = 0;
        StringBuilder check = new StringBuilder();
        Pattern patternHealth = Pattern.compile("[^\\d\\+\\-\\*\\/\\.]");
        Matcher matcherHealth = patternHealth.matcher(name);
        while (matcherHealth.find()) {
            check.append(matcherHealth.group());
        }
        for (int i = 0; i < check.length(); i++) {
            sum += check.charAt(i);
        }
        return sum;
    }
}
