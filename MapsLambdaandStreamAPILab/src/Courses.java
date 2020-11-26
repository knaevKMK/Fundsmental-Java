import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, ArrayList<String>> course = new LinkedHashMap<>();


        while (!"end".equals(input)) {
            String[] token = input.split(" : ");

            checkAndAddMapList(token, course);

            input = scanner.nextLine();
        }
        course
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry
                            .getValue()
                            .stream()
                            .sorted((a1, a2) -> a1.compareTo(a2))
                            .forEach(student -> System.out.println("    -- " + student));
                });
    }

    private static void checkAndAddMapList(String[] token, Map<String, ArrayList<String>> list) {
        list.putIfAbsent(token[0], new ArrayList<>());
        //       ArrayList<String> student = list.get(token[0]);
        //     student.add(token[1]);
        //   list.put(token[0], student);
        list.get(token[0]).add(token[1]);
    }
}
