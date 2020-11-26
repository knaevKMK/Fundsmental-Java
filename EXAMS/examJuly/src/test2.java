import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int complexity = Integer.parseInt(scanner.nextLine());
        int mix = Integer.parseInt(scanner.nextLine());
        int nPages = Integer.parseInt(scanner.nextLine());
        String type = "Regular";

        if (mix >= 50 && nPages >= 2) {
            type = "Hard";
        }

        if (complexity >= 80 && mix >= 80 && nPages >= 8) {
            type = "Legacy";
        } else if (complexity >= 80 && mix <= 10) {
            type = "Master";
        } else if (complexity <= 30 && complexity > 10 && nPages <= 1) {
            type = "Easy";
        } else if (complexity <= 10) {
            type = "Elementary";
        }
        System.out.println(type);
    }
}

