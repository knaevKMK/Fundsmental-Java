import java.text.DecimalFormat;
import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pointOneX = Double.parseDouble(scanner.nextLine());
        double pointOneY = Double.parseDouble(scanner.nextLine());
        double pointTwoX = Double.parseDouble(scanner.nextLine());
        double pointTwoY = Double.parseDouble(scanner.nextLine());

        printCloserPoint(pointOneX, pointOneY, pointTwoX, pointTwoY);
    }

    private static void printCloserPoint(double pointOneX, double pointOneY, double pointTwoX, double pointTwoY) {
        double winrX = 0;
        double winrY = 0;
        if (getCloserPoint(pointOneX, pointOneY) <= getCloserPoint(pointTwoX, pointTwoY)) {
            winrX = pointOneX;
            winrY = pointOneY;
        } else {
            winrX = pointTwoX;
            winrY = pointTwoY;
        }
        System.out.printf("(%.0f, %.0f)", winrX, winrY);
    }

    private static double getCloserPoint(double pointX, double pointY) {
        return Math.sqrt(Math.abs((Math.pow(pointX, 2)) + (Math.pow(pointY, 2))));
    }
}
