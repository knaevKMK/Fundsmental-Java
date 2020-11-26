import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> countNum = new TreeMap<>();

        for (double num : nums) {
            if (countNum.containsKey(num)) {
                countNum.put(num, countNum.get(num) + 1);
            } else {
                countNum.put(num, 1);
            }
        }
        DecimalFormat df = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : countNum.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
