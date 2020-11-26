import java.util.Scanner;

public class LowerorUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char read = scanner.nextLine().charAt(0);
        if (read >= 'a' && read<='z'){
            System.out.println("lower-case");
        } else if (read>='A'&& read<='Z'){
            System.out.println("upper-case");
        }
    }
}
