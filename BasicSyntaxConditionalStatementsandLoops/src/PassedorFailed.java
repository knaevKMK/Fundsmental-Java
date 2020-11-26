import java.util.Scanner;

public class PassedorFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        if (input<3.0){
            System.out.println("Failed!");
        } else {
            System.out.println("Passed!");
        }
    }
}
