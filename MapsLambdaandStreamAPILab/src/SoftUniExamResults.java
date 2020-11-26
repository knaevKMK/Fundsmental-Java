import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> gradeList = new TreeMap<>();
        Map<String, ArrayList<String>> examList = new TreeMap<>();

        String read = scanner.nextLine();
        while (!"exam finished".equals(read)) {
            String[] token = read.split("-", 2);
            String name = token[0];
            if ("banned".equals(token[1])) {
                removeMember(name, gradeList);
            } else {
                token = read.split("-", 3);
                String language = token[1];
                int score = Integer.parseInt(token[2]);
                addMember(name, language, score, gradeList, examList);
            }
            read = scanner.nextLine();
        }
        System.out.println("Results:");
        gradeList
                .entrySet()
                .stream()
                .sorted((a1, a2) -> Integer.compare(a2.getValue(), a1.getValue()))
                .forEach(a -> System.out.println(a.getKey() + " | " + a.getValue()));

        System.out.println("Submissions:");
        examList
                .entrySet()
                .stream()
                .sorted((a1, a2) -> Integer.compare(a2.getValue().size(), a1.getValue().size()))
                .forEach(a -> System.out.println(a.getKey() + " - " + a.getValue().size()));
    }

    private static void addMember(String name, String language, int score, Map<String, Integer> gradeList, Map<String, ArrayList<String>> examList) {
        examList.putIfAbsent(language, new ArrayList<String>());
        examList.get(language).add(name);

        gradeList.putIfAbsent(name, 0);
        if (score > gradeList.get(name)) {
            gradeList.put(name, score);
        }
    }

    private static void removeMember(String name, Map<String, Integer> gradeList) {

        gradeList.remove(name);
    }
}
