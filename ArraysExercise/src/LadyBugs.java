import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] Field = new int[Integer.parseInt(scanner.nextLine())];
        int[] Indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < Indexes.length; i++) {
            if (Indexes[i] >= 0 && Indexes[i] < Field.length) {
                Field[Indexes[i]] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] read = input.split(" ");
            int BugPosition = Integer.parseInt(read[0]);//index
            String direction = read[1];
            int flyLength = Integer.parseInt(read[2]);
            if (BugPosition < 0 || BugPosition >= Field.length || Field[BugPosition] == 0) {
                input = scanner.nextLine();
                continue;
            }

            Field[BugPosition] = 0;

            if (direction.equals("left")) {
                flyLength *= -1;
            }
            int curentFly = flyLength;
            while (BugPosition + curentFly >= 0
                    && BugPosition + curentFly < Field.length) {
                if (Field[BugPosition + curentFly] == 0) {
                    Field[BugPosition + curentFly] = 1;
                    break;
                } else {
                    curentFly += flyLength;
                }
            }
            input = scanner.nextLine();
        }

        for (
                int i = 0;
                i < Field.length; i++) {
            System.out.print(Field[i] + " ");
        }
    }
}
