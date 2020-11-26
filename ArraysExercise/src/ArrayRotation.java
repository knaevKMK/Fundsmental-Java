import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] read = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        String out = "";
        if (n > read.length) {
            n = n - read.length;
        }
        for (int i = 0; i < read.length - n; i++) {
            out = out + read[i + n] + " ";
        }
        for (int i = 0; i < n; i++) {
            out = out + read[i] + " ";
        }
        System.out.println(out);
    }
}
