import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] lineOne = new String[n];
        String[] lineTwo = new String[n];
        String lOne = "";
        String lTwo = "";

        for (int i = 0; i < n; i++) {
            String[] read = scanner.nextLine().split(" ");
            if (i % 2 != 0) {
                lineOne[i] = read[0];
                lineTwo[i] = read[1];
            } else {
                lineTwo[i] = read[0];
                lineOne[i] = read[1];
            }
            lOne = lOne + lineOne[i] + " ";
            lTwo = lTwo + lineTwo[i] + " ";
        }

        System.out.println(lTwo);
        System.out.println(lOne);
    }
}
