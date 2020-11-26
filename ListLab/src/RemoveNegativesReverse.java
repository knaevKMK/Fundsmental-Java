import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        printresult(nums);
    }

    private static void printresult(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (0 > nums.get(i)) {
                nums.remove(i);
                i -= 1;
            }
        }
        if (nums.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(nums);
            System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
