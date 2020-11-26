import java.util.Scanner;

public class get {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        while (n1 < n2 || n2 < n3) {
            if (n1 < n2) {
                int temp = n2;
                n2 = n1;
                n1 = temp;
            }
            if (n2 < n3) {
                int temp = n3;
                n3 = n2;
                n2 = temp;
            }
        }
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}
