import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String read = scanner.nextLine();

        while (!"end".equals(read)) {
            String decrypt = getIt(n, read);

            String name = getName("name", decrypt);
            String behavior = getName("behavior", decrypt);
            if (behavior.equals("G")) {
                System.out.println(name);
            }
            read = scanner.nextLine();
        }
    }

    private static String getName(String part, String decrypt) {
        final String regex = "@(?<name>[A-Za-z]+)" +
                "[^@\\-!:>]*" +
                "!(?<behavior>[GN])!";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(decrypt);
        if (matcher.find()) {
            return matcher.group(part);
        }
        return "not Match";
    }

    private static String getIt(int n, String read) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < read.length(); i++) {
            string.append((char) (read.charAt(i) - n));
        }
        return string.toString();
    }
}
