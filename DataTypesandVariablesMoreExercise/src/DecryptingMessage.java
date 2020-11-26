import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int pass = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= pass; i++) {
            char p = scanner.nextLine().charAt(0);
            int ch = (int) p + key;
            p = (char) ch;
            String print = "" + p;
            System.out.print(print);
        }
    }
}
