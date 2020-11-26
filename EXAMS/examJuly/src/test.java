import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int nValue = 0;

        int num11 = Integer.parseInt(scanner.nextLine());
        int num12 = Integer.parseInt(scanner.nextLine());
        int spiralCuurent = num11 + num12;
        int spiralCount = 0;
        int spiralStepMul = 1;

        boolean found = false;

        while (num3 < 1000000 && num11 < 1000000) {
            if (nValue == spiralCuurent) {
                System.out.println(nValue);
                found = true;
                break;
            } else if (nValue < spiralCuurent) {
                nValue = num1 + num2 + num3;
                num1 = num2;
                num2 = num3;
                num3 = nValue;
            } else {
                spiralCuurent += num12 * spiralStepMul;
                spiralCount++;

                if (spiralCount % 2 == 0) {
                    spiralStepMul++;
                }
            }
        }

        if (!found) {
            System.out.println("No");
        }
    }
}