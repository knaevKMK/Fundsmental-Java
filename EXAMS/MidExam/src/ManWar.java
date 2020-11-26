import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = new ArrayList<>();
        pirateShip = createList(scanner.nextLine(), pirateShip);
        List<Integer> warShip = new ArrayList<>();
        warShip = createList(scanner.nextLine(), warShip);

        int sectionHealthCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        boolean end = false;
        while (!"Retire".equals(command)) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Fire":
                    int index = Integer.parseInt(token[1]);
                    int damage = Integer.parseInt(token[2]);
                    if (index >= 0 && index < warShip.size()) {
                        if (damage >= warShip.get(index)) {
                            end = true;
                            System.out.println("You won! The enemy ship has sunken.");
                        } else {
                            setDamage(index, damage, warShip);
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    damage = Integer.parseInt(token[3]);
                    if (startIndex < endIndex && startIndex >= 0 && endIndex < pirateShip.size()) {
                        for (Integer integer : pirateShip) {
                            if (integer <= damage) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                end = true;
                                break;
                            }
                        }
                        if (!end) {
                            setDamageRange(startIndex, endIndex, damage, pirateShip);
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(token[1]);
                    int health = Integer.parseInt(token[2]);
                    if (index >= 0 && index < pirateShip.size()) {
                        setHealt(index, health, sectionHealthCapacity, pirateShip);
                    }
                    break;
                case "Status":
                    double downRangeHealt = sectionHealthCapacity * 0.2;

                    System.out.printf("%d sections need repair.%n", getNeedSections(downRangeHealt, pirateShip));
                    break;
            }
            if (end) {
                break;
            }
            command = scanner.nextLine();
        }

        if (!end) {
            System.out.printf("Pirate ship status: %d%n" +
                    "Warship status: %d", getSumSection(pirateShip), getSumSection(warShip));
        }
    }

    private static int getSumSection(List<Integer> ship) {
        int sum = 0;
        for (Integer integer : ship) {
            sum += integer;
        }

        return sum;
    }

    private static int getNeedSections(double downRangeHealt, List<Integer> ship) {
        int count = 0;
        for (Integer integer : ship) {
            if (integer < downRangeHealt) {
                count++;
            }
        }
        return count;
    }

    private static void setHealt(int index, int health, int sectionHealthCapacity, List<Integer> ship) {
        int temp = health + ship.get(index);
        if (temp > sectionHealthCapacity) {
            temp = sectionHealthCapacity;
        }
        ship.set(index, temp);
    }

    private static void setDamageRange(int startIndex, int endIndex, int damage, List<Integer> ship) {
        for (int i = startIndex; i <= endIndex; i++) {
            int temp = ship.get(i) - damage;
            ship.set(i, temp);
        }
    }

    private static void setDamage(int index, int damage, List<Integer> ship) {
        int temp = ship.get(index) - damage;
        ship.set(index, temp);
    }

    private static List<Integer> createList(String read, List<Integer> list) {
        String[] arr = read.split(">");
        for (String s : arr) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }
}
