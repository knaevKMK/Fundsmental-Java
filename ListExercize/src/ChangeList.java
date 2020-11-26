import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        List<Integer> nums = getList(data);
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] token = command.split("\\s+");
            int value = Integer.parseInt(token[1]);
            if ("Delete".equals(token[0])) {
                while (nums.contains(value)) {
                    nums.remove(Integer.valueOf(value));
                }
            } else if ("Insert".equals(token[0])) {
                int position = Integer.valueOf(token[2]);
                if (position >= 0 && position < nums.size()) {
                    nums.add(position, value);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> getList(String[] data) {
        List<Integer> creat = new ArrayList<>();
        for (String element : data) {
            creat.add(Integer.parseInt(element));
        }
        return creat;
    }
}
