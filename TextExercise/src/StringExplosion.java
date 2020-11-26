import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder read = new StringBuilder();
        int power = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '>') {
                power += Integer.parseInt(String.valueOf(line.charAt(i + 1)));
                read.append(">");
            } else if (power == 0) {
                read.append(line.charAt(i));
            } else {
                power--;
            }
        }
        System.out.println(read);
    }
}
