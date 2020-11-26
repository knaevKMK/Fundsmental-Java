import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        Map<String, Integer> legendaryItemMaterial = new LinkedHashMap<>();
        legendaryItemMaterial.put("shards", 0);
        legendaryItemMaterial.put("fragments", 0);
        legendaryItemMaterial.put("motes", 0);
        String input = scanner.nextLine();
        String winnner = "";

        while (true) {
            String[] read = input.toLowerCase().split("\\s+");
            for (int i = 1; i < read.length; i += 2) {
                int value = Integer.parseInt(read[i - 1]);
                if (read[i].equals("shards") || read[i].equals("fragments") || read[i].equals("motes")) {
                    addToMap(legendaryItemMaterial, value, read[i]);
                    if (checkWinner(legendaryItemMaterial)) {
                        winnner = read[i];
                        break;
                    }
                } else {
                    addToMap(materials, value, read[i]);
                }
            }
            if (!winnner.equals("")) {
                break;
            }
            input = scanner.nextLine();
        }

        printLegendaryItem(legendaryItemMaterial);

        materials.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static boolean checkWinner(Map<String, Integer> list) {
        boolean check = false;
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (entry.getValue() >= 250) {
                check = true;
                break;
            }
        }
        return check;
    }


    private static void printLegendaryItem(Map<String, Integer> list) {
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (entry.getValue() >= 250) {
                list.put(entry.getKey(), entry.getValue() - 250);
                System.out.println(getLegendaryItem(entry.getKey()) + " obtained!");
                break;
            }
        }

        list
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach((a) -> System.out.printf("%s: %d%n", a.getKey(), a.getValue()));

    }

    private static String getLegendaryItem(String key) {
        switch (key) {
            case "shards":
                key = "Shadowmourne";
                break;
            case "fragments":
                key = "Valanyr";
                break;
            case "motes":
                key = "Dragonwrath";
                break;
        }
        return key;
    }

    private static void addToMap(Map<String, Integer> list, int value, String s) {
        list.putIfAbsent(s, 0);
        list.put(s, list.get(s) + value);
    }
}