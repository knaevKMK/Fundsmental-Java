import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String check = scanner.nextLine();

        //  StringBuilder result = new StringBuilder(scanner.nextLine());
        //  while (result.toString().contains(check)) {
        //      int startIndex = result.indexOf(check);
        //      int endIndex = result.indexOf(check) + check.length();
        //      result.delete(startIndex, endIndex);
        //  }

        String result = scanner.nextLine();
        while (result.contains(check)) {
            result = result.substring(0, result.indexOf(check)) + result.substring(result.indexOf(check) + check.length());
        }
        System.out.println(result);
    }
}
