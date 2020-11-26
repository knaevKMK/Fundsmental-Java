import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] keySequence = scanner.nextLine().split("\\s+");
        String line = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        while (!"find".equals(line)) {
            int[] key = new int[line.length()];
            key = equalLenght(key, keySequence);

            for (int i = 0; i < line.length(); i++) {
                String replace = "" + ((char) (line.charAt(i) - key[i]));
                result.append(replace);
            }

            String type = result.substring(result.indexOf("&")+1, result.lastIndexOf("&"));
            String place = result.substring(result.indexOf("<")+1, result.indexOf(">"));
            line = scanner.nextLine();
            System.out.println("Found " + type + " at " + place);
            result.delete(0, result.length());
        }
    }

    private static int[] equalLenght(int[] key, String[] sequence) {
        int n = 1;
        for (int i = 0; i < key.length; i++) {
            if (i >= sequence.length * n) {
                n++;
            }
            key[i] = Integer.parseInt(sequence[i - sequence.length * (n - 1)]);
        }
        return key;
    }
}
