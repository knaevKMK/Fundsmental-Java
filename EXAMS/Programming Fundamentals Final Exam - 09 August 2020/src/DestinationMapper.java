import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    private static Scanner scanner = new Scanner(System.in);
    private static final String patern = "([=/])(?<group>[A-Z][A-Za-z]{2,})\\1";
    public static void main(String[] args) {
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile(patern);
        Matcher matcher = pattern.matcher(text);
        List<String> cities = new ArrayList<>();
        int destinations = 0;
        while (matcher.find()) {
            String temp = matcher.group(2);
            destinations += temp.length();
            cities.add(temp);
        }
        StringBuilder result = new StringBuilder("Destinations: ");
        for (int i = 0; i < cities.size(); i++) {
            result.append(cities.get(i));
            if (i!= cities.size()-1){
                result.append(", ");
            }
        }
        System.out.println(result.toString());
        System.out.println("Travel Points: " + destinations);
    }
}
