import java.util.Arrays;
import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] code = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

            if (code[0] == 0) {
                System.out.print(" ");
                continue;
            }
            int ofset = (code[0] - 2) * 3;
            if (code[0] == 8 || code[0] == 9) {
                ofset++;
            }
            int ascII = 97 + ofset + code.length - 1;
            System.out.print(String.valueOf((char) (ascII)));
        }
    }
}
