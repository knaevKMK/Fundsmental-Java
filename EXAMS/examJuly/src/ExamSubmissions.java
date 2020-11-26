import java.util.Scanner;

public class ExamSubmissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int student = Integer.parseInt(scanner.nextLine());
        int exersize = Integer.parseInt(scanner.nextLine());



        double rezult = student * Math.ceil(exersize * 2.8);
        double extra = student * (exersize / 3);
        rezult += extra;
        double memory = Math.ceil(rezult / 10);
        memory *= 5;
        System.out.printf("%.0f KB needed%n", memory);
        System.out.printf("%.0f submissions", rezult);
    }
}
