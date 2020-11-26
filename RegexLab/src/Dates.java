import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Dates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern dates = Pattern.compile("\\b(?<day>[\\d]{2})([\\/\\-\\.])(?<moth>[A-Z][a-z]{2})\\2(?<year>[\\d]{4})\\b");
        Matcher matcher = dates.matcher(line);
        //   while (matcher.find()){
        //       System.out.println(String.format("Day: %s, Month: %s, Year: %s",
        //               matcher.group(1),
        //               matcher.group(3),
        //               matcher.group(4)));
        //   }

        List<String> datesList = Arrays
                .stream(line.split("[,\\s+]"))
                .filter(dates.asPredicate())
                .collect(Collectors.toList());

        datesList.forEach(date ->
        {
            String [] subToken = date.split("[-\\.\\/]");
            System.out.printf("Day: %s, Month: %s, Year: %s%n", subToken[0],subToken[1],subToken[2]);
        });
    }
}

