import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\|");
        List<String> result = new ArrayList<>();
        result = addLement(data, result);
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));


    }

    private static List<String> addLement(String[] data, List<String> result) {
        for (int i = data.length - 1; i >= 0; i--) {
            String[] temp = data[i].split("\\s+");
            for (String s : temp) {
                if (!"".equals(s)) {
                    result.add(s);
                }
            }
        }
        return result;
    }
}
