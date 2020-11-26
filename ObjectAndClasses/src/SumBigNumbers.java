import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger one = new BigInteger(scanner.nextLine());
        BigInteger two = new BigInteger(scanner.nextLine());

        BigInteger sum = one.add(two);
        System.out.println(sum);
    }

}