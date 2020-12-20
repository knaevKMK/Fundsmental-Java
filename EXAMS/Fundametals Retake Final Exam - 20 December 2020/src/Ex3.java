import java.util.*;

public class Ex3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, List<String>> list = new LinkedHashMap<>();

        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            String[] data = read.split("\\s"); // TODO regexSplit
            String command = data[0];
            String name = data[1];
            String spellName;

            switch (command) {
                case "Enroll":
                    if (list.containsKey(name)) {
                        printResult(name + " is already enrolled.");
                    } else {
                        list.putIfAbsent(name, new ArrayList<>());
                    }
                    break;
                case "Learn":
                    if (!list.containsKey(name)) {
                        printResult(name + " doesn't exist.");
                    } else {
                        spellName = data[2];
                        if (list.get(name).contains(spellName)) {
                            printResult(name + " has already learnt " + spellName + ".");
                        } else {
                            list.get(name).add(spellName);
                        }
                    }
                    break;
                case "Unlearn":
                    if (!list.containsKey(name)) {
                        printResult(name + " doesn't exist.");
                    } else {
                        spellName = data[2];
                        if (!list.get(name).contains(spellName)) {
                            printResult(name + " doesn't know " + spellName + ".");
                        } else {
                            list.get(name).remove(spellName);
                        }
                    }
                    break;
            }
        }
        printResult(getHeros(list));
    }

    private static String getHeros(Map<String, List<String>> list) {
        StringBuilder print = new StringBuilder("Heroes:").append(System.lineSeparator());
        list.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().size(), a.getValue().size());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(heroes -> print.append(String.format("== %s: ", heroes.getKey()))
        .append(heroes.getValue().toString().replaceAll("[\\[\\]]",""))
        .append(System.lineSeparator()));


        return print.toString().trim();
    }

    private static void printResult(String s) {
        System.out.println(s);
    }
}
