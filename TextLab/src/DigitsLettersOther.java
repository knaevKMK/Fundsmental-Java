import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  List<Character> line = Arrays.stream(scanner.nextLine().split(""))
        //          .map(s -> s.charAt(0))
        //          .collect(Collectors.toList());

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        String read = scanner.nextLine();
        for (int i = 0; i < read.length(); i++) {
            char s = read.charAt(i);
            //  for (Character s : line) {
            if (Character.isAlphabetic(s)) {
                letters.append(s);
            } else if (Character.isDigit(s)) {
                digits.append(s);
            } else {
                others.append(s);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}

