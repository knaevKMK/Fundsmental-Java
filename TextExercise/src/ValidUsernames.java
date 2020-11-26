import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] users = scanner.nextLine().split(", ");
        for (String user : users) {
            //•	Has length between 3 and 16 characters
            //•	Contains only letters, numbers, hyphens and underscores
            //•	Has no redundant symbols before, after or in between.
            if (isValid(user)) {
                System.out.println(user);
            }
        }
    }

    private static boolean isValid(String user) {
        if (user.length() < 3 || user.length() > 16) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            char ch = user.charAt(i);
            if (!Character.isLetterOrDigit(ch)
                    && (ch != '-')
                    && ch != '_') {
                return false;
            }
        }
        return true;
    }
}
