import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> playerOne = new ArrayList();
        playerOne = getList(scanner.nextLine());
        List<Integer> playerTwo = new ArrayList();
        playerTwo = getList(scanner.nextLine());

        while (shortSize(playerOne, playerTwo) > 0) {
            int curentPlaeyerOneCard = playerOne.remove(0);
            int curentPlaeyerTwoCard = playerTwo.remove(0);

            if (curentPlaeyerOneCard > curentPlaeyerTwoCard) {
                playerOne.add(curentPlaeyerOneCard);
                playerOne.add(curentPlaeyerTwoCard);
            } else if (curentPlaeyerOneCard < curentPlaeyerTwoCard) {
                playerTwo.add(curentPlaeyerTwoCard);
                playerTwo.add(curentPlaeyerOneCard);
            }
        }
        String winner = getWinner(playerOne, playerTwo);
        int sumWinner = getSumOfWinner(winner, playerOne, playerTwo);
        System.out.printf("%s player wins! Sum: %d", winner, sumWinner);
    }

    private static int getSumOfWinner(String winner, List<Integer> playerOne, List<Integer> playerTwo) {
        int sum = 0;
        if ("First".equals(winner)) {
            sum = getSum(playerOne);
        } else if ("Second".equals(winner)) {
            sum = getSum(playerTwo);
        }
        return sum;
    }

    private static int getSum(List<Integer> player) {
        int sum = 0;
        for (Integer integer : player) {
            sum += integer;
        }
        return sum;
    }

    private static String getWinner(List<Integer> playerOne, List<Integer> playerTwo) {
        String winner = "First";
        if (playerTwo.size() > playerOne.size()) {
            winner = "Second";
        }
        return winner;
    }


    private static int shortSize(List<Integer> playerOne, List<Integer> playerTwo) {
        int size = playerOne.size();
        if (playerOne.size() > playerTwo.size()) {
            size = playerTwo.size();
        }
        return size;
    }

    private static List<Integer> getList(String nextLine) {
        String[] data = nextLine.split("\\s+");
        List<Integer> create = new ArrayList<>();
        for (String element : data) {
            create.add(Integer.parseInt(element));
        }
        return create;
    }
}
