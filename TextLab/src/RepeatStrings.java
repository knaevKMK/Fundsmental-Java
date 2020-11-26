import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //      String[] words = scanner.nextLine().split("\\s+");

        String result = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(w -> getWords(w, w.length()))
                .collect(Collectors.joining());

//
        //      StringBuilder result = new StringBuilder();
        //      for (String word : words) {
        //          result.append(getWords(word));
        //      }
        System.out.println(result);
    }

    private static String getWords(String words, int length) {
        String result = "";
        for (int i = 0; i < words.length(); i++) {
            result += words;
        }
        return result;
    }
}
