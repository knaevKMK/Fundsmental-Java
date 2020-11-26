import com.sun.source.tree.IfTree;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, String>> dragon = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] token = scanner.nextLine().split("\\s+", 3);
            String type = token[0];
            String name = token[1];
            String power = token[2];
            if (token[2].contains("null")) {
                String[] data = token[2].split("\\s+");
                checkNull(data);
                power = String.format("%s %s %s", data[0], data[1], data[2]);
            }
            dragon.putIfAbsent(type, new TreeMap<>());
            dragon.get(type).put(name, power);
        }
        // Map<String, List<String>> result = new LinkedHashMap<>();
        // result = getIt(result, dragon);
        // result
        //         .entrySet()
        //         .forEach(type -> {
        //             System.out.println(type.getKey());
        //             type.getValue().forEach(a -> System.out.println(a));
        //         });

        dragon
                .entrySet()
                .forEach(type -> {
                    double damageAverage = 0;
                    double healtAverage = 0;
                    double armorAverage = 0;
                    for (Map.Entry<String, String> entry : type.getValue().entrySet()) {
                        String[] data = entry.getValue().split("\\s+");
                        damageAverage += Double.parseDouble(data[0]);
                        healtAverage += Double.parseDouble(data[1]);
                        armorAverage += Double.parseDouble(data[2]);
                    }
                    damageAverage = damageAverage / type.getValue().size();
                    healtAverage = healtAverage / type.getValue().size();
                    armorAverage = armorAverage / type.getValue().size();
                    System.out.println(type.getKey() + String.format("::(%.2f/%.2f/%.2f)", damageAverage, healtAverage, armorAverage));
                    type
                            .getValue()
                            .forEach((k, v) -> {
                                String[] data = v.split("\\s+");
                                System.out.println("-" + k + String.format(" -> damage: %s, health: %s, armor: %s", data[0], data[1], data[2]));

                            });
                });

    }

    private static Map<String, List<String>> getIt(Map<String, List<String>> result, Map<String, TreeMap<String, String>> dragon) {
        for (Map.Entry<String, TreeMap<String, String>> entry : dragon.entrySet()) {
            double damageAverage = 0;
            double healtAverage = 0;
            double armorAverage = 0;
            List<String> check = new ArrayList<>();
            for (Map.Entry<String, String> subEntry : entry.getValue().entrySet()) {
                String[] data = subEntry.getValue().split("\\s+");
                if (subEntry.getValue().contains("null")) {
                    checkNull(data);
                }
                String currentDragon = "-" + subEntry.getKey() + String.format(" -> damage: %s, health: %s, armor: %s", data[0], data[1], data[2]);
                check.add(currentDragon);

                damageAverage += Double.parseDouble(data[0]);
                healtAverage += Double.parseDouble(data[1]);
                armorAverage += Double.parseDouble(data[2]);
            }
            damageAverage = damageAverage / entry.getValue().size();
            healtAverage = healtAverage / entry.getValue().size();
            armorAverage = armorAverage / entry.getValue().size();
            String currentType = entry.getKey() + String.format("::(%.2f/%.2f/%.2f)", damageAverage, healtAverage, armorAverage);
            result.put(currentType, check);
        }
        return result;
    }

    private static String[] checkNull(String[] data) { // : health 250, damage 45, and armor 10. Missing stat will be marked by null
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("null")) {
                if (i == 1) {
                    data[i] = "250";
                } else if (i == 0) {
                    data[i] = "45";
                } else {
                    data[i] = "10";
                }
            }
        }
        return data;
    }
}
