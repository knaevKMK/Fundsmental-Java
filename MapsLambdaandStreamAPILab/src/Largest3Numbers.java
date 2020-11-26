import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

        nums.stream()
                .limit(3)
                .forEach(a -> System.out.print(a + " "));

    }
}
