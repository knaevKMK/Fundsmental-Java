import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        List<Integer> nums = getList(data);

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] token = command.split("\\s+");

            switch (token[0]) {
                case "Add":
                    int value = Integer.parseInt(token[1]);
                    nums.add(value);
                    break;

                case "Insert":
                    value = Integer.parseInt(token[1]);
                    int index = Integer.parseInt(token[2]);
                    if (isvalid(nums, index)) {
                        nums.add(index, value);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    index = Integer.parseInt(token[1]);
                    if (isvalid(nums, index)) {
                        nums.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(token[2]);
                    if ("left".equals(token[1])) {
                        for (int i = 0; i < count; i++) {
                            int temp = nums.remove(0);
                            nums.add(temp);
                        }
                    } else if ("right".equals(token[1])) {
                        for (int i = 0; i < count; i++) {
                            int temp = nums.remove(nums.size() - 1);
                            nums.add(0, temp);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));
    }

    private static boolean isvalid(List<Integer> nums, int index) {
        boolean valid = index >= 0 && index < nums.size();
        return valid;
    }


    private static List<Integer> getList(String[] data) {
        List<Integer> create = new ArrayList<>();
        for (String element : data) {
            create.add(Integer.parseInt(element));
        }
        return create;
    }
}
