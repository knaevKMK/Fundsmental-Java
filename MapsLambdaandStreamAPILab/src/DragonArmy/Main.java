package DragonArmy;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> dwarf = new TreeMap<>();
        String read = scanner.nextLine();
        while (!"Once upon a time".equals(read)) {
            String[] token = read.split(" <:> ");
            String name = token[0];
            String hatColor = token[1];
            int physics = Integer.parseInt(token[2]);

            addInMap(name, hatColor, physics, dwarf);
            read = scanner.nextLine();
        }

        Map<String, Integer> dwarfPrint = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarf.entrySet()) {
            for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                dwarfPrint.put(entry.getKey() + " " + value.getKey() + " " + entry.getValue().size(), value.getValue());
            }
        }

        dwarfPrint.entrySet()
                .stream()
                .sorted((a2, a1) -> {
                    String[] ramOne = a1.getKey().split(" ");
                    String[] ramTwo = a2.getKey().split(" ");
                    int result = a1.getValue().compareTo(a2.getValue());
                    if (result == 0) {
                        result = ramOne[2].compareTo(ramTwo[2]);
                    }
                    return result;
                })
                .forEach(element -> {
                    String[] token = element.getKey().split(" ");
                    System.out.printf("(%s) %s <-> %d%n", token[0], token[1], element.getValue());
                });
    }

    private static void addInMap(String name, String hatColor, int physics, Map<String, LinkedHashMap<String, Integer>> dwarf) {
        dwarf.putIfAbsent(hatColor, new LinkedHashMap<>());
        LinkedHashMap<String, Integer> names = dwarf.get(hatColor);
        names.putIfAbsent(name, 0);
        if (names.get(name) < physics) {
            names.put(name, physics);
        }
    }

}
