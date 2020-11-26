import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder read = new StringBuilder(scanner.nextLine());
        int i = 0;
        while (i<read.length()-1) {
                if (read.charAt(i) == read.charAt(i + 1)) {
                    read.deleteCharAt(i + 1);
                    i--;
                }
            i++;
        }
        System.out.println(read);
        //List<String> read = Arrays.stream(scanner.nextLine()
        //        .split(""))
        //        .collect(Collectors.toList());

        //   for (int i = 1; i < read.size(); i++) {
        //       if (read.get(i - 1).equals(read.get(i))) {
        //           read.remove(i);
        //           i--;
        //       }
        //   }
        // read.forEach(s -> System.out.print(s));
    }
}
