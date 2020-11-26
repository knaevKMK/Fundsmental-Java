import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            int value = Integer.parseInt(tokens[1]);
            switch (tokens[0]) {
                case "Add":
                    nums.add(value);
                    break;
                case "Remove":
                    nums.remove(Integer.valueOf(value));
                    break;
                case "RemoveAt":
                    nums.remove(value);
                    break;
                case "Insert":
                    int command3 = Integer.parseInt(tokens[2]);
                    nums.add(command3, value);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.print(nums.toString().replaceAll("[\\[\\],]", ""));

    }

}
