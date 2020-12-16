import com.sun.source.tree.IfTree;

import java.util.*;
import java.util.regex.Pattern;

public class PlantDiscovery {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> list = new LinkedHashMap<>(); //"{plant}<->{rarity}".
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("<->");
            list.putIfAbsent(data[0], new ArrayList<>());
            list.get(data[0]).add(0, Double.parseDouble(data[1]));
        }

        String read;
        while (!"Exhibition".equals(read = scanner.nextLine())) {
            String[] data = read.split("(: )|( - )");
            String command = data[0];
            String plant = data[1];
            if (list.containsKey(plant)) {
                switch (command) {
                    case "Rate":
                        double rarity = Double.parseDouble(data[2]);
                        list.get(plant).add(rarity);// collect ratings
                        break;
                    case "Update":
                        double raiting = Double.parseDouble(data[2]);
                        list.get(plant).set(0, raiting);
                        break;
                    case "Reset":
                        double temp = list.get(plant).get(0);
                        list.get(plant).clear();
                        list.get(plant).add(temp);
                        break;
                    default:
                        System.out.println("error");
                }
            }else {
                System.out.println("error");
            }
        }
        System.out.println("Plants for the exhibition:");
        list.entrySet().stream()
                .sorted((a, b) -> {
                    int reslt = Double.compare(b.getValue().get(0), a.getValue().get(0));
                    if (reslt == 0) {
                        reslt = Double.compare(averageRating(b.getValue()), averageRating(a.getValue()));
                        //getValue().stream().skip(1).mapToDouble(Double::doubleValue).average().orElse(0.0)
                        //a.getValue().stream().skip(1).mapToDouble(Double::doubleValue).average().orElse(0.0));
                    }
                    return reslt;
                }).
                forEach(s -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", s.getKey(), s.getValue().

                        get(0), averageRating(s.getValue())));

    }

    private static double averageRating(List<Double> value) {
        return value.stream().skip(1).mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

}
