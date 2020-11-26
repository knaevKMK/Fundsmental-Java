import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lootArray = scanner.nextLine().split("\\|");
        List<String> lootList = new ArrayList<>();
        for (String s : lootArray) {
            lootList.add(s);
        }

        String command = scanner.nextLine();

        while (!"Yohoho!".equals(command)) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Loot": // pick up treasure loot along the way. Insert the items at the beginning of the chest.
                    // If an item is already contained don't insert it.
                    checkAndAddExist(token, lootList);
                    break;
                case "Drop": //remove the loot at the given position and add it at the end of the treasure chest.
                    // If the index is invalid skip the command.
                    dropPosition(token[1], lootList);
                    break;
                case "Steal":// someone steals the last count loot items.
                    // If there are less items than the given count remove as much as there are.
                    // Print the stolen items separated by ', ':
                    stealLoot(token[1], lootList);
                    break;
            }
            command = scanner.nextLine();
        }
        if (lootList.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", getAverageGain(lootList));
        }
    }

    private static double getAverageGain(List<String> lootList) {
        double averageLneght = 0;
        for (int i = 0; i < lootList.size(); i++) {
            averageLneght += lootList.get(i).length();
        }
        averageLneght = averageLneght / lootList.size();
        return averageLneght;
    }

    private static void stealLoot(String s, List<String> lootList) {
        int last = Integer.parseInt(s);
        if (last > lootList.size()) {
            last = lootList.size();
        }
        int start = lootList.size() - 1;
        int end = lootList.size() - last;
        String print = "";
        for (int i = start; i >= end; i--) {
            print = lootList.get(i) + ", " + print;
            lootList.remove(i);
        }
        if (print.length() > 2) {
            print = print.substring(0, print.length() - 2);
        }

        System.out.println(print);

    }

    private static void dropPosition(String s, List<String> lootList) {
        int index = Integer.parseInt(s);
        if (index >= 0 && index < lootList.size()) {
            String temp = lootList.get(index);
            lootList.remove(index);
            lootList.add(temp);
        }
    }

    private static void checkAndAddExist(String[] token, List<String> lootList) {
        for (int i = 1; i < token.length; i++) {
            boolean isNotEqual = true;
            for (String s : lootList) {
                if (token[i].equals(s)) {
                    isNotEqual = false;
                    break;
                }
            }
            if (isNotEqual) {
                lootList.add(0, token[i]);
            }
        }
    }

}
