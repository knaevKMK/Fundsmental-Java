import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNum = Integer.parseInt(scanner.nextLine());
        long secondNum = Integer.parseInt(scanner.nextLine());
        long thitrthNum = Integer.parseInt(scanner.nextLine());
        long fourthNum = Integer.parseInt(scanner.nextLine());

        long sum = firstNum + secondNum;
        long result = sum  / thitrthNum;
        long total = result * fourthNum;
        System.out.println(total);

    }
}
