import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] read = scanner.nextLine().split("\\s+");
        List<Integer> integers = new ArrayList<>();
        for (String s : read) {
            integers.add(Integer.parseInt(s));
        }
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] token = command.split("\\s+");

            switch (token[0]) {
                case "swap":
                    int indexOne = Integer.parseInt(token[1]);
                    int indexTwo = Integer.parseInt(token[2]);
                    swapIntegers(indexOne, indexTwo, integers);
                    break;
                case "multiply":
                    indexOne = Integer.parseInt(token[1]);
                    indexTwo = Integer.parseInt(token[2]);
                    multiplyIntegers(indexOne, indexTwo, integers);

                    break;
                case "decrease":
                    decreaseList(integers);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(integers.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void multiplyIntegers(int indexOne, int indexTwo, List<Integer> list) {
        int temp = list.get(indexOne) * list.get(indexTwo);
        list.set(indexOne, temp);
    }

    private static void swapIntegers(int indexOne, int indexTwo, List<Integer> list) {
        int temp = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, temp);
    }

    private static void decreaseList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i) - 1;
            list.set(i, temp);
        }
    }
}
