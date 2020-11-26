import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrOne = scanner.nextLine().split(" ");
        String[] arrTwo = scanner.nextLine().split(" ");
        int sum = 0;
        boolean notEqual = false;

        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i].equals(arrTwo[i])) {
                sum += Integer.parseInt(arrOne[i]);
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                notEqual = true;
                break;
            }
        }
        if (!notEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
