import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        String mVal = "";
        int max = 0;
        for (int i = 0; i < line.length; i++) {
            int count = 0;

            for (int j = i + 1; j < line.length; j++) {
                if (line[i].equals(line[j])) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > max) {
                max = count;
                mVal = "";
                for (int k = 0; k <= count; k++) {
                    mVal = mVal + line[i] + " ";
                }
            }
        }
        String print = String.join(" ", mVal);
        System.out.println(print);
    }
}

