import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> quantytiList = new LinkedHashMap<>();
        Map<String, Double> priceList = new LinkedHashMap<>();
        String read = scanner.nextLine();
        while (!"buy".equals(read)) {
            String[] token = read.split("\\s+");
            putQuantityList(quantytiList, token[0], token[2]);
            putPriceList(priceList, token[0], token[1]);

            read = scanner.nextLine();
        }

        printMapLit(priceList, quantytiList);
    }

    private static void putQuantityList(Map<String, Integer> list, String name, String quantity) {
        list.putIfAbsent(name, 0);
        list.put(name, list.get(name) + Integer.parseInt(quantity));
    }

    private static void putPriceList(Map<String, Double> list, String name, String price) {
        double priceOrder = Double.parseDouble(price);
        list.putIfAbsent(name, priceOrder);
        list.put(name, priceOrder);

    }

    private static void printMapLit(Map<String, Double> list, Map<String, Integer> quantytiList) {
        for (Map.Entry<String, Double> entry : list.entrySet())
            System.out.println(String.format("%s -> %.2f", entry.getKey(), entry.getValue() * quantytiList.get(entry.getKey())));
    }


}
