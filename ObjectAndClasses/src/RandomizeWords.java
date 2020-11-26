import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        printRandom(line);
    }

    private static void printRandom(String[] array) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            int index = rnd.nextInt(array.length);

            String temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        for (String s : array) {
            System.out.println(s);
        }
    }
}
