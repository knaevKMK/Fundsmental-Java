import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] check = scanner.nextLine().split(", ");
        StringBuilder result = new StringBuilder(scanner.nextLine());

//          String result=scanner.nextLine();
        for (String s : check) {
//            result = result.replaceAll(s, getStar(s));
            while (result.toString().contains(s)) {
                int startIndex = result.indexOf(s);
                int endIndex = startIndex + s.length();
                result.replace(startIndex, endIndex, getStar(s));
            }
        }
        System.out.println(result);
    }

    private static String getStar(String check) {
        String result = "";
        for (int i = 0; i < check.length(); i++) {
            result += "*";
        }
        return result;
    }
}
