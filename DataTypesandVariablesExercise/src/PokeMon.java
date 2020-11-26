import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());// poke power
        int m = Integer.parseInt(scanner.nextLine());// distance between the poke targets
        byte y = Byte.parseByte(scanner.nextLine()); // exhaustionFactor

        int targets = 0;
        int currenPower = n;

        while (currenPower >= m) {

            currenPower -= m;
            targets++;

            if (currenPower == n / 2 && y != 0) {
                currenPower /= y;
            }
        }
        System.out.println(currenPower);
        System.out.println(targets);
    }
}
