import java.util.Scanner;

public class CondenseArraytoNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] num = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }

        while (num.length > 1) {
            int[] sum = new int[num.length - 1];
            for (int i = 0; i < num.length - 1; i++) {
                sum[i] = num[i] + num[i + 1];
            }
            num = sum;
        }
        System.out.println(num[0]);
    }
}

