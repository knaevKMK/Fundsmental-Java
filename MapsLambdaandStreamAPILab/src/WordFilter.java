import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] word = Arrays.stream(scanner.nextLine().split("\\s+"))
                .toArray(String[]::new);


        Arrays.stream(word)
                .filter(a -> a.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
