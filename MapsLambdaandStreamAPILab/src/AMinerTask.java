import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> list = new LinkedHashMap<>();
        int count = 0;
        String key = "";
        int value = 0;
        while (!"stop".equals(input)) {
            count++;
            if (count % 2 == 1) {
                value = Integer.parseInt(input);
                key = input;
            }
            if (count % 2 == 0) {
                list.putIfAbsent(key, 0);
                list.put(key, list.get(key) + value);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
