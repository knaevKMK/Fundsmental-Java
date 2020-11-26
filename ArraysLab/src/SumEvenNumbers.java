
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nums = scanner.nextLine();
        String[] arr = nums.split(" ");
        int[] value = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            value[i] = Integer.parseInt(arr[i]);
        }

        // int[] value = Arrays.stream(scanner.nextLine().split(" "))
        //       .mapToInt(n -> Integer.parseInt(n)).toArray();
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                sum += value[i];
            }
        }
        System.out.println(sum);
    }
}
