import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<String>> words = new LinkedHashMap<>();
        for (int j = 1; j <= n; j++) {
            String word = scanner.nextLine();
            String sinonim = scanner.nextLine();
            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(sinonim);
        }
        printMap(words);
    }

    private static void printMap(Map<String, ArrayList<String>> words) {
        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString().replaceAll("[]\\[\\]]", ""));

        }
    }
}
