import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] token = command.split(" ");
            switch (token[0]) {
                case "Contains":
                    int value = Integer.parseInt(token[1]);
                    System.out.println(checkValue(value, nums));
                    break;
                case "Print":
                    if (token[1].equals("even")) {
                        getEvenNums(nums);
                        System.out.println();
                    } else if (token[1].equals("odd")) {
                        getOddNums(nums);
                        System.out.println();
                    }
                    break;
                case "Get":
                    if (token[1].equals("sum")) {
                        printSum(nums);
                    }
                    break;
                case "Filter":
                    String condition = token[1];
                    int n = Integer.parseInt(token[2]);
                    printConditons(condition, n, nums);
                    break;
            }


            command = scanner.nextLine();
        }

    }

    private static void printConditons(String condition, int n, List<Integer> nums) {
        String out = "";
        switch (condition) {
            case ">":
                for (int num : nums) {
                    if (num > n) {
                        out = out + num + " ";
                    }
                }
                break;
            case "<":
                for (int num : nums) {
                    if (num < n) {
                        out = out + num + " ";
                    }
                }
                break;
            case ">=":
                for (int num : nums) {
                    if (num >= n) {
                        out = out + num + " ";
                    }
                }
                break;
            case "<=":
                for (int num : nums) {
                    if (num <= n) {
                        out = out + num + " ";
                    }
                }
                break;
        }
        System.out.println(out);
    }

    private static void printSum(List<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println(sum);
    }

    private static void getOddNums(List<Integer> nums) {
        for (int num : nums) {
            if (num % 2 == 1) {
                System.out.print(num + " ");
            }
        }
    }

    private static void getEvenNums(List<Integer> nums) {
        for (int num : nums) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
    }

    private static String checkValue(int value, List<Integer> nums) {
        String yes = "No such number";
        for (int num : nums) {
            if (num == value) {
                yes = "Yes";
                break;
            }
        }
        return yes;
    }
}
