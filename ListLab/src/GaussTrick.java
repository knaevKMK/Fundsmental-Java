import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> num = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        printResult(num);
    }

    private static void printResult(List<Integer> num) {
        for (int i = 0; i < num.size() ; i++) {
            if (i==num.size()-1){
                break;
            }
            num.set(i, (num.get(i) + num.get(num.size() - 1)));
            num.remove(num.size() - 1);
        }
        System.out.println(num.toString().replaceAll("[\\[\\],]", "") + " ");
    }
}
