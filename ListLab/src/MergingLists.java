import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> one = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> two = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        printResult(one, two);
    }

    private static void printResult(List<String> one, List<String> two) {
        int i = 0;
        while (i <= longSize(one, two)) {
            if (i <= one.size() - 1) {
                System.out.print(one.get(i) + " ");
            }
            if (i <= two.size() - 1) {
                System.out.print(two.get(i) + " ");
            }
            i++;
        }
    }

    private static int longSize(List<String> one, List<String> two) {
        int longSize = one.size() - 1;
        if (one.size() <= two.size()) {
            longSize = two.size() - 1;
        }
        return longSize;
    }
}


