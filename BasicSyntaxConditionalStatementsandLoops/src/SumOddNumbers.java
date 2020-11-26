import java.util.Scanner;

public class SumOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;
        int sum = 0;
        while (n > 0) {

            if (i % 2 != 0) {
                System.out.println(i);
                sum += i;
                n--;
            }
            i++;
        }
        System.out.printf("Sum: %d", sum);
    }
}
