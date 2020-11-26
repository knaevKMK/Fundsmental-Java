import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] read = scanner.nextLine().split("\\s+");
        List<String> sequense = new ArrayList<>();
        for (String s : read) {
            sequense.add(s);
        }

        int moves = 0;
        String command = scanner.nextLine();
        boolean win = false;
        while (!"end".equals(command)) {
            moves++;
            int[] index = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (!checkNotCheat(index, sequense)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                String add = "-" + moves + "a";
                for (int i = 0; i < 2; i++) {
                    sequense.add(getMiddle(sequense.size()), add);
                }
            } else {
                if (checkEqualsOfIngex(index, sequense)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequense.get(index[0]));
                    removeElement(index, sequense);
                } else {
                    System.out.println("Try again!");
                }
            }
            if (sequense.isEmpty()) {
                System.out.printf("You have won in %d turns!", moves);
                win = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (!win) {
            System.out.println("Sorry you lose :(");
            printResult(sequense);
        }
    }

    private static void printResult(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    private static void removeElement(int[] index, List<String> list) {
        if (index[0] < index[1]) {
            int temp = index[0];
            index[0] = index[1];
            index[1] = temp;
        }
        for (int i : index) {
            list.remove(i);
        }
    }

    private static boolean checkEqualsOfIngex(int[] index, List<String> list) {
        return list.get(index[0]).equals(list.get(index[1]));
    }


    private static int getMiddle(int size) {
        if (size % 2 == 0) {
            return size / 2 ;
        } else {
            return size / 2+1;
        }
    }


    private static boolean checkNotCheat(int[] index, List<String> list) {
        boolean valid = true;
        for (int i : index) {
            if (i < 0 || i >= list.size()) {
                valid = false;
                break;
            }
        }
        if (index[0] == index[1] && valid) {
            valid = false;
        }
        return valid;
    }

}
