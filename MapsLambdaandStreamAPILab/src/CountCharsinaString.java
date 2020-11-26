import java.util.*;

public class CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> text = new LinkedHashMap<>();

        String[] read = scanner.nextLine()
                .replaceAll("\\s+", "")
                .split("");

        for (String s : read) {
            text.putIfAbsent(s, 0);
            text.put(s, text.get(s) + 1);
        }


        for (Map.Entry<String, Integer> entry : text.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
