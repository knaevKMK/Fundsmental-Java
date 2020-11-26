import java.util.Scanner;

public class ExamPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int exr = Integer.parseInt(scanner.nextLine());
        int score = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int koef = 0;
        switch (exr) {
            case 1:
                if (input.equals("Basics")) {
                    koef = 8;
                } else if (input.equals("Fundamentals")) {
                    koef = 11;
                } else if (input.equals("Advanced")) {
                    koef = 14;
                }
                break;
            case 2:
                if (input.equals("Basics")) {
                    koef = 9;
                } else if (input.equals("Fundamentals")) {
                    koef = 11;
                } else if (input.equals("Advanced")) {
                    koef = 14;
                }
                break;
            case 3:
                if (input.equals("Basics")) {
                    koef = 9;
                } else if (input.equals("Fundamentals")) {
                    koef = 12;
                } else if (input.equals("Advanced")) {
                    koef = 15;
                }
                break;
            case 4:
                if (input.equals("Basics")) {
                    koef = 10;
                } else if (input.equals("Fundamentals")) {
                    koef = 13;
                } else if (input.equals("Advanced")) {
                    koef = 16;
                }
                break;
        }
        double result = koef * score*0.01;
        if (input.equals("Advanced")) {
            result *= 1.2;
        }
        if (exr == 1 && input.equals("Basics")) {
            result *= 0.8;
        }


        System.out.printf("Total points: %.2f", result);
    }
}
