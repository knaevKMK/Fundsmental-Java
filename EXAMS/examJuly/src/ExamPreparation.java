import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stud = Integer.parseInt(scanner.nextLine());
        int exr = Integer.parseInt(scanner.nextLine());
        double power = Integer.parseInt(scanner.nextLine());

        int i = 0;
        int questions = 0;
        double totQues = 0;
        boolean flag = false;
        boolean flag2 = false;


        while (power > 0) {
            i += exr;
            power = power + 2 * exr;
            stud -= exr;
            questions = stud * 2;

            for (int j = 1; j <= questions; j++) {
                power -= 3;
                if (power <= 0) {
                    flag2 = true;
                    break;
                }
            }
            totQues += questions;
            if (flag2) {
                break;
            }
            if (stud < 10) {
                flag = true;
                break;
            }
            double add = Math.floor(stud * 0.1);
            stud = (int) (stud + add);

        }

        if (flag) {
            System.out.printf("The students are too few!%nProblems solved: %d", i);
        } else {
            System.out.printf("The trainer is too tired!%nQuestions asked: %d", totQues);

        }
    }
}
