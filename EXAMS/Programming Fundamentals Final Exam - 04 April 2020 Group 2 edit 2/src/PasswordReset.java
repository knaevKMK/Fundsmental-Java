import java.util.Scanner;

public class PasswordReset {
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder text;

    public static void main(String[] args) {
        text = new StringBuilder(scanner.nextLine());
        editText();
        printText("Your password is: " + text);
    }

    private static void printText(String s) {
        System.out.println(s);
    }

    private static void editText() {

        while (true) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            String result;
            switch (command) {
                case "TakeOdd":
                    result = takeOdd();
                    break;
                case "Cut":
                    int index = Integer.parseInt(data[1]);
                    int count = Integer.parseInt(data[2]);
                    result = cut(index, count);
                    break;
                case "Substitute":
                    String old = data[1];
                    String substitute = data[2];
                    result = substituteText(old, substitute);
                    break;
                case "Done":
                    return;
                default:
                    continue;
            }
            printText(result);
        }
    }

    private static String substituteText(String old, String substitute) {
        String temp = text.toString();
        if (temp.contains(old)) {
            temp = temp.replace(old, substitute);
            text.setLength(0);
            text.append(temp);
            return (text.toString());
        }
        return ("Nothing to replace!");
    }

    private static String cut(int index, int count) {
        text.delete(index, index + count);
        return (text.toString());
    }

    private static String takeOdd() {
        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < text.length(); i += 2) {
            temp.append(text.charAt(i));
        }
        text = new StringBuilder(temp);
        return (temp.toString());
    }
}
