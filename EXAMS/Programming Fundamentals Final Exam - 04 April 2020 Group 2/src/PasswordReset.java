import java.util.Locale;
import java.util.Scanner;

public class PasswordReset {
    private static Scanner scanner = new Scanner(System.in);
    private static String text;
    private static StringBuilder result;

    public static void main(String[] args) {
        result = new StringBuilder();
        text = scanner.nextLine();

        String read;
        while (!"Done".equals(read = scanner.nextLine())) {
            String[] data = read.split(" ");
            switch (data[0]) {
                case "TakeOdd":
                    takeOddChart();
                    break;
                case "Cut":
                    cutCharts(data);
                    break;
                case "Substitute":
                    substitute(data);
                    break;
            }
        }
        System.out.println("Your password is: " + text);
    }

    private static void substitute(String[] data) {
        String subString = data[1];
        String substitutea = data[2];
        if (!text.contains(subString)) {
            System.out.println("Nothing to replace!");
            return;
        }
        text = text.replace(subString, substitutea);
        printResult();
    }

    private static void cutCharts(String[] data) {
        int index = Integer.parseInt(data[1]);
        int count = Integer.parseInt(data[2]);
        text = new StringBuilder(text).delete(index, index + count).toString();
        printResult();
    }


    private static void printResult() {
        System.out.println(text);
    }

    private static void takeOddChart() {
        for (int i = 1; i < text.length(); i += 2) {
            result.append(text.charAt(i));
        }
        text = result.toString();
        result = new StringBuilder();
        printResult();
    }
}
