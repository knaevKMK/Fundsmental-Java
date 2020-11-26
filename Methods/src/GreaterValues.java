import java.util.Scanner;

public class GreaterValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        getMax(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
    }


    private static void getMax(String input, String one, String second) {
        String bigger = "one";
        switch (input) {
            case "int":
                int oneInt = Integer.parseInt(one);
                int secondInt = Integer.parseInt(second);
                bigger = String.valueOf(checkInt(oneInt, secondInt));
                break;
            case "char":
                char oneCh = one.charAt(0);
                char secondCh = second.charAt(0);
                bigger = String.valueOf(checkChar(oneCh, secondCh));
                break;
            case "string":
                bigger = String.valueOf(checkString(one, second));
                break;
        }
        System.out.println(bigger);
    }

    private static int checkInt(int oneInt, int secondInt) {
        int bigger = oneInt;
        if (oneInt < secondInt) {
            bigger = secondInt;
        }
        return bigger;
    }

    private static char checkChar(char oneCh, char secondCh) {
        char bigger = oneCh;
        if (oneCh < secondCh) {
            bigger = secondCh;
        }
        return bigger;
    }

    private static String checkString(String one, String second) {
        String longer = one;
        if (one.length() < second.length()) {
            longer = second;
        }
        return longer;
    }


}
