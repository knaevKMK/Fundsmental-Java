import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeat = Integer.parseInt(scanner.nextLine());

        System.out.println(getStringLine(input, repeat));
    }

    private static Object getStringLine(String input, int repeat) {
        String result = "";
        for (int i = 0; i < repeat; i++) {
            result += input;
        }
        return result;
    }
}
