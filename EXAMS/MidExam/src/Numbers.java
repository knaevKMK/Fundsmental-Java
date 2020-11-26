import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] read = scanner.nextLine().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        double average = 0;
        for (String s : read) {
            int num = Integer.parseInt(s);
            nums.add(num);
            average += num;
        }
        average /= nums.size();
        List<Integer> result = new ArrayList<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) > average) {
                result.add(nums.get(i));
            }
        }
        if (result.isEmpty()) {
            System.out.println("No");
        } else {
            result.sort(Integer::compareTo);
            int end = result.size();
            if (end > 5) {
                end = 5;
            }
            for (int i = result.size() - 1; i >= result.size() - end; i--) {
                System.out.print(result.get(i) + " ");
            }

        }
    }
}
