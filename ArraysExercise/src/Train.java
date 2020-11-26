import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] num = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(scanner.nextLine());
            sum += num[i];
            System.out.print(num[i]+" ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
