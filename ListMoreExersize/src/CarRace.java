import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] read = scanner.nextLine().split("\\s+");
        List<Double> list = new ArrayList<>();
        list = getList(read);
        String[] winner = getWinner(list);
        System.out.printf("The winner is %s with total time: %s", winner[0], winner[1]);
    }

    private static List<Double> getList(String[] read) {
        List<Double> list = new ArrayList<>();
        for (String element : read) {
            list.add(Double.parseDouble(element));
        }
        return list;
    }

    private static String[] getWinner(List<Double> list) {
        int midleIndex = list.size() / 2;
        String[] get = new String[2];
        double left = 0;
        double right = 0;

        for (int i = 0; i < midleIndex; i++) {
            left = getSum(left, list.get(i));
        }
        for (int i = list.size() - 1; i > midleIndex; i--) {
            right = getSum(right, list.get(i));
        }
        double lower = left;
        String winner = "left";
        if (right < left) {
            lower = right;
            winner = "right";
        }

        get[1] = String.valueOf(lower);
        get[0] = winner;
        return get;
    }

    private static double getSum(double sum, double current) {
        if (current == 0) {
            sum *= 0.8;
        } else {
            sum += current;
        }
        return sum;
    }
}