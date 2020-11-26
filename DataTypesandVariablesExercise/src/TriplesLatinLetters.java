import java.util.Scanner;

public class TriplesLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i < 97+n; i++) {
            char pOne = (char) i;
            for (int j = 97; j < 97+n; j++) {
                char pTwo = (char) j;
                for (int k = 97; k < 97+n; k++) {
                    char pTree = (char) k;
                    System.out.printf("%c%c%c%n",pOne,pTwo,pTree);
                }
            }
        }
    }
}
