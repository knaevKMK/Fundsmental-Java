import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] scan = new double[8];
        for (int i = 0; i < 8; i++) {
            scan[i] = Double.parseDouble(scanner.nextLine());
        }
        double[] pointOne = {scan[0], scan[1]};
        double[] pointTwo = {scan[2], scan[3]};
        double[] pointThree = {scan[4], scan[5]};
        double[] pointFour = {scan[6], scan[7]};

        printLongerLine(pointOne, pointTwo, pointThree, pointFour);
    }

    private static void printLongerLine(double[] pointOne, double[] pointTwo, double[] pointThree, double[] pointFour) {
        double[] longerLinePointOne = pointOne;
        double[] longerLinePointTwo = pointTwo;

        if (getLineLong(pointOne, pointTwo) < getLineLong(pointThree, pointFour)) {
            longerLinePointOne = pointThree;
            longerLinePointTwo = pointFour;
        }
        printChechAndReplaceClosedPointofLongerLine(longerLinePointOne, longerLinePointTwo);
    }

    private static double getLineLong(double[] pointOne, double[] pointTwo) {

        return Math.sqrt(Math.abs(Math.pow((pointOne[0] - pointTwo[0]), 2) + Math.pow((pointOne[1] - pointTwo[1]), 2)));
    }

    private static void printChechAndReplaceClosedPointofLongerLine(double[] pointOne, double[] pointTwo) {

        if (getlineFromPoints(pointTwo) < getlineFromPoints(pointOne)) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", pointTwo[0], pointTwo[1], pointOne[0], pointOne[1]);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", pointOne[0], pointOne[1], pointTwo[0], pointTwo[1]);
        }

    }

    private static double getlineFromPoints(double[] point) {
        return Math.sqrt(Math.abs((Math.pow(point[0], 2)) + (Math.pow(point[1], 2))));
    }
}
