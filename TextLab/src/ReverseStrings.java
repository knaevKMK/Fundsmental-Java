import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        while (!"end".equals(read)) {
            String reverse = getRevers(read);
            //new StringBuilder(read).reverse().toString();
            System.out.println(read + " = " + reverse);
            read = scanner.nextLine();
        }
    }

    private static String getRevers(String read) {
        String result = "";
        for (int i = read.length() - 1; i >= 0; i--) {
            result += read.charAt(i);
        }
        return result;
    }
}
