import java.text.DecimalFormat;
import java.util.Scanner;

public class MatPow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.###");
        System.out.println(df.format(getMathPowResult(num, pow)));
    }

    private static double getMathPowResult(double num, int pow) {
        double resultPow = 1;
        resultPow = Math.pow(num, pow);
        return resultPow;

    }
}
