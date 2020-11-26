import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String read = scanner.nextLine();
            String name = read.substring(read.indexOf('@') + 1, read.indexOf('|'));
            int age = Integer.parseInt(read.substring(read.indexOf("#") + 1, read.indexOf("*")));
            System.out.println(String.format("%s is %d years old.", name, age));
        }
    }
}
