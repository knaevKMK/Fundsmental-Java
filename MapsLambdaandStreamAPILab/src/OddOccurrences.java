import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> words = new LinkedHashMap<>();

        for (String s : line) {
            words.putIfAbsent(s, 0);
            words.put(s, words.get(s) + 1);
        }
        printOddCount(words);
    }

    private static void printOddCount(Map<String, Integer> words) {
        List<String> oddCountWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCountWords.add(entry.getKey());
            }
        }

        System.out.println(oddCountWords.toString().replaceAll("[\\[\\]]", ""));
    }
}
