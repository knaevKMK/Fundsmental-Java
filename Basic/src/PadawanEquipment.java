import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double funds = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double bellPrice = Double.parseDouble(scanner.nextLine());

        lightsabersPrice = lightsabersPrice * Math.ceil(students * 1.1);
        robesPrice *= students;
        int discounted = students / 6;
        students -= discounted;
        bellPrice *= students;
        double order = lightsabersPrice + robesPrice + bellPrice;

        if (order > funds) {
            System.out.printf("Ivan Cho will need %.2flv more.", order - funds);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.", order);
        }
    }
}
