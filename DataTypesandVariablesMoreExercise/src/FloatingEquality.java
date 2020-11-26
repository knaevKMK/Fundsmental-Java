import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        int aA = (int) (a * 1000000);
        int bB = (int) (b * 1000000);

        boolean equals = aA == bB;
        String print = String.valueOf(equals);
        print = print.substring(0, 1).toUpperCase() + print.substring(1).toLowerCase();
        System.out.print(print);
    }
}
