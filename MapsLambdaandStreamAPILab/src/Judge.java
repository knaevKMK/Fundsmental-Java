import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> contestList = new LinkedHashMap<>();
        Map<String, Integer> membersList = new TreeMap<>();

        while (!"no more time".equals(read)) {
            //{username} -> {contest} -> {points}
            String[] token = read.split(" -> ");
            String name = token[0];
            String contest = token[1];
            int score = Integer.parseInt(token[2]);

            creatAndAddElement(name, contest, score, contestList);
            read = scanner.nextLine();
        }
        int[] counter = new int[1];

        contestList
                .entrySet()
                .stream()
                .forEach(contest ->
                {
                    counter[0] = 1;
                    System.out.println(contest.getKey() + ": " + contest.getValue().size() + " participants");


                    contest
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted((a1, a2) ->
                                    {
                                       int sort = Integer.compare(a2.getValue(), a1.getValue());
                                        if (sort == 0) {
                                            sort = a1.getKey().compareTo(a2.getKey());
                                        }
                                        return sort;
                                    })
                            .forEach(entry -> System.out.printf("%d. %s <::> %d%n", counter[0]++, entry.getKey(), entry.getValue()));
                });
        creatAndAddinMmeberList(membersList, contestList);
        System.out.println("Individual standings:");
        counter[0] = 1;
        membersList.entrySet()
                .stream()
                .sorted((a1, a2) -> {
                    int sort = Integer.compare(a2.getValue(), a1.getValue());
                    if (sort == 0) {
                        sort = a1.getKey().compareTo(a2.getKey());
                    }
                    return sort;
                })
                .forEach((a -> System.out.printf("%d. %s -> %d%n", counter[0]++, a.getKey(), a.getValue())));
    }

    private static void creatAndAddinMmeberList(Map<String, Integer> membersList, Map<String, TreeMap<String, Integer>> contestList) {
        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestList.entrySet()) {
            for (Map.Entry<String, Integer> element : entry.getValue().entrySet()) {
                String name = element.getKey();
                int scoreAdd = element.getValue();
                membersList.putIfAbsent(name, 0);
                int currentScore = membersList.get(name);
                membersList.put(name, scoreAdd + currentScore);
            }
        }
    }

    private static void creatAndAddElement(String name, String contest, int score, Map<String, TreeMap<String, Integer>> contestList) {
        contestList.putIfAbsent(contest, new TreeMap<>());
        contestList.get(contest).putIfAbsent(name, 0);

        if (score > contestList.get(contest).get(name)) {
            contestList.get(contest).put(name, score);

        }


    }
}
