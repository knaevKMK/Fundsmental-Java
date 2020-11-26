import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] english = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?"};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};

        Map<String, String> morseDictionary = new LinkedHashMap<>();
        for (int i = 0; i < english.length; i++) {
            morseDictionary.putIfAbsent(morse[i], english[i]);
        }
        String[] line = scanner.nextLine().split(" ");


        for (int i = 0; i < line.length; i++) {

            if (line[i].equals("|")) {
                System.out.print(" ");
            } else {
                System.out.print(morseDictionary.get(line[i]).toUpperCase());
            }
        }

    }

}
