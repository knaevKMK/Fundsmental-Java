import java.util.Scanner;

public class SignofIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        printSign(num);

    }

    private static void printSign(int number) {
        String sign = "";
        if (number > 0 ){
            sign="positive";
        }else if (number<0){
            sign="negative";
        } else {
            sign="zero";
        }
        System.out.printf("The number %d is %s.", number, sign);
    }
}
