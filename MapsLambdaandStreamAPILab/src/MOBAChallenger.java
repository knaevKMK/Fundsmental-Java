import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        Map<String, Map<String, Integer>> players = new TreeMap<>();

        while (!"Season end".equals(read)) {
            String[] token = read.split("\\s+", 3);
            String name = token[0];
            switch (token[1]) {
                case "->":
                    String[] nextToken = token[2].split(" -> ");
                    String position = nextToken[0];
                    int skill = Integer.parseInt(nextToken[1]);
                    addInList(name, position, skill, players);
                    break;
                case "vs":
                    String playerTwo = token[2];
                    duelPlayers(name, playerTwo, players);
                    break;
            }
            read = scanner.nextLine();
        }
        players
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values()
                                    .stream()
                                    .mapToInt(i -> i)
                                    .sum(),
                            p1.getValue().values()
                                    .stream()
                                    .mapToInt(i -> i)
                                    .sum());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().values().stream().mapToInt(i -> i).sum() + " skill");
                    entry
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted((a1, a2) -> {
                                int resultPrime = a2.getValue().compareTo(a1.getValue());
                                if (resultPrime == 0) {
                                    resultPrime = a1.getKey().compareTo(a2.getKey());
                                }
                                return resultPrime;
                            })
                            .forEach(elemnt -> System.out.println("- " + elemnt.getKey() + " <::> " + elemnt.getValue()));
                });

    }

    private static void duelPlayers(String name, String playerTwo, Map<String, Map<String, Integer>> players) {
        if (checkPlayer(name, players) && checkPlayer(playerTwo, players)) {
            for (Map.Entry<String, Integer> value : players.get(name).entrySet()) {
                String position = value.getKey();
                if (players.get(playerTwo).containsKey(position)) {
                    int skillOne = value.getValue();
                    int skillTwo = players.get(playerTwo).get(position);
                    if (skillOne < skillTwo) {
                        players.remove(name).remove(position);
                        removeEmptyPlayers(name, players);
                    } else if (skillOne > skillTwo) {
                        players.get(playerTwo).remove(position);
                        removeEmptyPlayers(playerTwo, players);
                    }
                }
            }
        }
    }

    private static void removeEmptyPlayers(String player, Map<String, Map<String, Integer>> players) {
        if (players.get(player).isEmpty()) {
            players.remove(player);
        }
    }

    private static boolean checkPlayer(String player, Map<String, Map<String, Integer>> playersList) {
        return playersList.containsKey(player);
    }

    private static void addInList(String name, String position, int skill, Map<String, Map<String, Integer>> players) {
        players.putIfAbsent(name, new TreeMap<>());
        players.get(name).putIfAbsent(position, 0);
        players.get(name).put(position, skill + players.get(name).get(position));
    }
}
