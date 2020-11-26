import java.util.Scanner;

public class ExamRetention {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stud = Integer.parseInt(scanner.nextLine());
        int season = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        double cont = 0;
        double resign = 0;
        for (int i = 1; i <= season; i++) {
            for (int j = 1; j <= 2; j++) {
                sum = Math.ceil(stud * 0.9);
                stud = (int) sum;
            }
            cont = Math.ceil(stud * 0.8);
            stud = (int) cont;
            if (i % 3 == 0) {
                resign = Math.ceil(cont * 0.15);
            } else {
                resign = Math.ceil(cont * 0.05);
            }
            stud += resign;
        }
        System.out.printf("Students: %d", stud);
    }
}
