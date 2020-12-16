import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    private static Scanner scanner = new Scanner(System.in);
    private static String text;
    private static Pattern pattern = Pattern.compile("([|#])(?<food>[A-Za-z\\s]{1,})\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<call>\\d{1,5})\\1");

    public static class Food {
        private String name;
        private String date;
        private int cal;

        public Food(String name, String date, int cal) {
            this.name = name;
            this.date = date;
            this.cal = cal;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public int getCal() {
            return cal;
        }
    }

    public static void main(String[] args) {
        text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);
        List<Food> list = new ArrayList<>();
        while (matcher.find()) {
            String name = matcher.group("food");
            String date = matcher.group("date");
            int cal = Integer.parseInt(matcher.group("call"));
            list.add(new Food(name, date, cal));
        }
        int totalCal = list.stream().mapToInt(Food::getCal).sum();
        int days = totalCal / 2000;
        System.out.println(String.format("You have food to last you for: %d days!", days));
        list.forEach(food -> System.out.println(String.format("Item: %s, Best before: %s, Nutrition: %d"
                , food.getName(), food.getDate(), food.getCal())));
    }
}
