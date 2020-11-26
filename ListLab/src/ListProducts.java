import java.util.*;

public class ListProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> product = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            product.add(i, scanner.nextLine());
        }
        printResult(product);
    }

    private static void printResult(List<String> product) {
        Collections.sort(product);
        for (int i = 0; i < product.size(); i++) {
            System.out.println(i + 1 + "." + product.get(i));
        }
    }
}
