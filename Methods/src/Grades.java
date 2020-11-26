import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        printValStringGrade(grade);
    }

    private static void printValStringGrade(double grade) {
        String gradeName = "";
        if (grade >= 5.5 && grade <= 6.0) {
            gradeName = "Excellent";
        } else if (grade >= 4.5) {
            gradeName = "Very good";
        } else if (grade >= 3.5) {
            gradeName = "Good";
        } else if (grade >= 3.0) {
            gradeName = " Poor";
        } else if (grade >= 2.0) {
            gradeName = "Fail";
        }
        System.out.printf("%s", gradeName);
    }
}
