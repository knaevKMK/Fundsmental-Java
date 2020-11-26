import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String noChars = input.replaceAll("!+", "");
        String[] noZeros = noChars.split("0");
        String localSequence = "";
        localSequence = noZeros[0];
        int localIndex = noChars.indexOf(localSequence);
        System.out.println(localIndex);
    }
}
