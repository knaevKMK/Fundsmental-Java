import java.util.Scanner;

public class SecretChat {

    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder text;

    public static void main(String[] args) {
        text = new StringBuilder(scanner.nextLine());

        String read;
        while (!"Reveal".equals(read = scanner.nextLine())) {
            String[] data = read.split(":\\|:");
            String substring = data[1];
            String temp = text.toString();
            switch (data[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(substring);
                    text.insert(index, " ");
                    printResult(text.toString());
                    break;
                case "Reverse":
                    if (!temp.contains(substring)) {
                        printResult("error");
                    } else {
                        temp = temp.replaceFirst(substring, "");
                        substring = new StringBuilder(substring).reverse().toString();
                        text = new StringBuilder(temp).append(substring);
                        printResult(text.toString());
                    }
                    break;
                case "ChangeAll":
                    String replacement = data[2];
                    if (temp.contains(substring)) {
                        temp = temp.replace(substring, replacement);
                        text = new StringBuilder(temp);
                        printResult(text.toString());
                    } else {
                        printResult("error");
                    }
                    break;
            }
        }
        printResult("You have a new text message: " + text);
    }

    private static void printResult(String s) {
        System.out.println(s);
    }
}
