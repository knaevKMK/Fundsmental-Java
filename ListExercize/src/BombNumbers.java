import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        List<Integer> nums = getList(data);
        String[] command = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(command[0]);
        int power = Integer.parseInt(command[1]);

        while (nums.contains(bomb)) {
            int index = nums.indexOf(bomb);
            int sizeLeft = index - power;
            if (sizeLeft < 0) {
                sizeLeft = 0;
            }

            int sizeRight = index + power;
            if (sizeRight > nums.size() - 1) {
                sizeRight = nums.size() - 1;
            }

            for (int i = sizeRight; i >= sizeLeft; i--) {
                nums.remove(i);
            }
        }
        int sum = getSum(nums);
        System.out.println(sum);

    }

    private static int getSum(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }

    private static List<Integer> getList(String[] data) {
        List<Integer> create = new ArrayList<>();
        for (String datum : data) {
            create.add(Integer.parseInt(datum));
        }
        return create;
    }
}
