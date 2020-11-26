import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nums = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
        //   StringBuilder nums = new StringBuilder(scanner.nextLine());

        int power = Integer.parseInt(scanner.nextLine());
        if (power == 0) {
            System.out.println(0);
            return;
        }
        int reminder = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            int current = Integer.parseInt(nums.get(i)) * power + reminder;
            reminder = 0;
            reminder = current / 10;
            current %= 10;
            nums.set(i, String.valueOf(current));
        }
        if (reminder > 0) {
            nums.add(0, String.valueOf(reminder));
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).equals("0")) {
                nums.remove(i);
                i--;
            } else {
                break;
            }
        }
        // for (int i = nums.size() - 1; i >= 0; i--) {
        //    System.out.print(nums.get(i));
        //}

        nums.forEach(s -> System.out.print(s));
    }
}
