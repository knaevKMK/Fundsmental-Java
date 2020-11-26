import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] read = scanner.nextLine().split("\\s+");

        int shorter = read[0].length() < read[1].length() ? read[0].length() : read[1].length();
        int longer = read[0].length() > read[1].length() ? read[0].length() : read[1].length();
        int sum = 0;
        for (int i = 0; i < longer; i++) {

            if (i < shorter) {
                sum = sum + read[0].charAt(i) * read[1].charAt(i);
            } else if (read[0].length() == shorter) {
                sum += read[1].charAt(i);
            } else {
                sum += read[0].charAt(i);
            }
        }
        System.out.println(sum);
    }
}
