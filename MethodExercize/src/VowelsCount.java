import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();

        printVowelCount(data);
    }

    public static void printVowelCount(String input) {
        int countVowel = 0;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i') {
                countVowel++;
            }
        }
        System.out.println(countVowel);
    }
}
