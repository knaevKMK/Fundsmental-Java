import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        List<Integer> wagon = getList(data);
        int maxPasangers = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] token = command.split("\\s+");
            int value = 0;
            if ("Add".equals(token[0])) {
                value = Integer.parseInt(token[1]);
                wagon.add(Integer.valueOf(token[1]));
            } else {
                value = Integer.parseInt(token[0]);
                for (int i = 0; i < wagon.size(); i++) {
                    int sum = wagon.get(i) + value;
                    if (sum <= maxPasangers) {
                        wagon.set(i, sum);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(wagon.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> getList(String[] data) {
        List<Integer> creat = new ArrayList<>();
        for (String datum : data) {
            creat.add(Integer.valueOf(datum));
        }
        return creat;
    }
}
