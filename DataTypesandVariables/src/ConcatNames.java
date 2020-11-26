import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String family = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.printf("%s%s%s", name, delimiter, family);
    }
}
