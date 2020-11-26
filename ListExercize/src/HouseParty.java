import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        int guest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < guest; i++) {
            String[] comand = scanner.nextLine().split("\\s+", 3);
            String name = comand[0];
            if ("going!".equals(comand[2])) {
                if (!names.contains(comand[0])) {
                    names.add(comand[0]);
                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            } else if ("not going!".equals(comand[2])) {
                if (names.contains(comand[0])) {
                    names.remove(String.valueOf(name));
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
