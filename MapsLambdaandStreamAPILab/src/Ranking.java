import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        ArrayList<String> contest = new ArrayList<>();
        Map<String, Map<String, Integer>> members = new TreeMap<>();

        while (!"end of contests".equals(read)) {
//"{contest}:{password for contest}
            String check = read.replaceAll(":", " ");
            contest.add(check);
            read = scanner.nextLine();
        }
        read = scanner.nextLine();
        while (!"end of submissions".equals(read)) {
//{contest}=>{password}=>{username}=>{points}"
            String[] token = read.split("=>");
            checkAndPutInList(token, contest, members);
            read = scanner.nextLine();
        }
        int sum = 0;
        String winner = "";
        for (Map.Entry<String, Map<String, Integer>> entry : members.entrySet()) {
            int currentSum = entry.getValue().values().stream().mapToInt(a -> a).sum();
            if (currentSum > sum) {
                sum = currentSum;
                winner = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", winner, sum);
        System.out.println("Ranking: ");
        members
                .forEach((key, value) ->

                {
                    System.out.println(key);
                    value.entrySet()
                            .stream()
                            .sorted((a1, a2) -> Integer.compare(a2.getValue(), a1.getValue()))
                            .forEach(a -> System.out.printf("#  %s -> %d%n", a.getKey(), a.getValue()));
                });

    }

    private static void checkAndPutInList(String[] token, ArrayList<String> contest, Map<String, Map<String, Integer>> members) {
        String check = token[0] + " " + token[1];
        String name = token[2];
        int score = Integer.parseInt(token[3]);

        if (contest.contains(check)) {
            members.putIfAbsent(name, new TreeMap<>());
            members.get(name).putIfAbsent(token[0], 0);
            if (score > members.get(name).get(token[0])) {
                members.get(name).put(token[0], score);
            }
        }
    }
}
