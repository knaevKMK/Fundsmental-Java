import java.util.Scanner;

public class EvenandOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] num = new int[arr.length];
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
            if (num[i] % 2 == 0) {
                sumEven += num[i];
            } else {
                sumOdd += num[i];
            }
        }

        System.out.println(sumEven - sumOdd);
    }
}
