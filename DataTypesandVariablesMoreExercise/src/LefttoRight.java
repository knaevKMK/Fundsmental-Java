import java.util.Scanner;

public class LefttoRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            StringBuilder one = new StringBuilder();
            StringBuilder two = new StringBuilder();
            boolean stop = false;
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == ' ') {
                    stop = true;
                    continue;
                }
                if (stop) {
                    two.append(ch);
                } else {
                    one.append(ch);
                }
            }
            long numLeft = Long.parseLong(one.toString());
            long numRight = Long.parseLong(two.toString());
            long numToCheck = 0;
            if (numLeft > numRight) {
                numToCheck = numLeft;
            } else {
                numToCheck = numRight;
            }
            if (numToCheck < 0) {
                numToCheck *= -1;
            }

            long sum = 0;
            while (numToCheck > 0) {
                sum = sum + (numToCheck % 10);
                numToCheck /= 10;
            }
            System.out.println(sum);
        }
    }
}
