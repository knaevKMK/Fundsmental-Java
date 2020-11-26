import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int opend = 0;
        int closed = 0;
        boolean unbalance = false;
        for (int i = 1; i <= n; i++) {
            String in = scanner.nextLine();
            if (in.equals("(")) {
                opend++;
            }
            if (in.equals(")")) {
                closed++;
                if (opend < closed) {
                    unbalance = true;
                }
            }

        }
        if ((opend == closed) && !unbalance) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
