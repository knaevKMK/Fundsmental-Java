import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double funds = Double.parseDouble(scanner.nextLine());
        List<Integer> bumpers = new ArrayList();
        String[] read = scanner.nextLine().split("\\s+");
        bumpers = getList(read);
        List<Integer> checkNew = new ArrayList();
        checkNew = getList(read);
        String play = scanner.nextLine();

        while (!"Hit it again, Gabsy!".equals(play)) {
            int power = Integer.parseInt(play);
            for (int i = 0; i < bumpers.size(); i++) {
                int curentPower = bumpers.get(i) - power;
                bumpers.set(i, curentPower);
                int startValue = checkNew.get(i);
                double currentPrice = startValue * 3.0;
                if (bumpers.get(i) <= 0) {
                    if (funds - currentPrice >= 0) {
                        funds = funds - currentPrice;
                        bumpers.set(i, startValue);
                    }
                }
            }

            for (int i = 0; i < bumpers.size(); i++) {
                if (bumpers.get(i) <= 0) {
                    bumpers.remove(i);
                    checkNew.remove(i);
                    i--;
                }
            }
            play = scanner.nextLine();
        }
        System.out.println(bumpers.toString().

                replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", funds);
    }

    private static List<Integer> getList(String[] nextLine) {
        List<Integer> list = new ArrayList<>();
        for (String s : nextLine) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
