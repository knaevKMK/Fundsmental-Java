import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double best = Integer.MIN_VALUE;

        int snowBest = 0;
        int timeBest = 0;
        int qualityBest = 0;
        if (n >= 0 && n <= 100) {
            for (int i = 1; i <= n; i++) {
                int snow = Integer.parseInt(scanner.nextLine());
                int time = Integer.parseInt(scanner.nextLine());
                int quality = Integer.parseInt(scanner.nextLine());
                if ((snow >= 0 && snow <= 1000) && (time >= 1 && time <= 500) && (quality >= 0 && quality <= 100)) {
                    int value = snow / time;
                    double totalvalue = Math.pow(value, quality);

                    if (totalvalue > best) {
                        best = totalvalue;
                        snowBest = snow;
                        timeBest = time;
                        qualityBest = quality;
                    }
                }
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snowBest, timeBest, best, qualityBest);
    }
}
