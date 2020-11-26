import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumEmployeeefency = 0;
        for (int i = 0; i < 3; i++) {
            sumEmployeeefency += Integer.parseInt(scanner.nextLine());
        }
        int students = Integer.parseInt(scanner.nextLine());
        int hour = 0;
        while (students > 0) {
            hour++;

            if (hour % 4 == 0) {
                hour++;
            }
            students -= sumEmployeeefency;
        }
        System.out.printf("Time needed: %dh.", hour);
    }
}
