import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> indexes = new ArrayList<>();
        indexes = getList(scanner.nextLine());
        String data = scanner.nextLine();

        String result = "";
        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) > data.length()) {
                indexes.set(i, getValidIndex(data.length(), indexes.get(i)));
            }
            result += data.charAt(indexes.get(i) + i);
        }
        System.out.println(result);

    }

    private static Integer getValidIndex(int length, Integer integer) {
        while (integer > length) {
            integer -= length;
        }
        return integer;
    }

    private static List<Integer> getList(String code) {
        String[] values = code.split("\\s+");
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            int[] codeNums = Arrays.stream(values[i].split("")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int elemen : codeNums) {
                sum += elemen;
            }
            indexes.add(sum);
        }
        return indexes;
    }
}
