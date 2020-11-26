import java.util.*;
import java.util.stream.Collectors;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Character> read = Arrays
                .stream(scanner.nextLine().split(""))
                .map(s -> s.charAt(0))
                .collect(Collectors.toList());

            read
                .forEach(ch-> System.out.print((char)(Integer.valueOf(ch)+3)));
//
  //      for (Character ch : read) {
  //          String add = "" + ((char) (Integer.valueOf(ch)+3));
  //          System.out.print(add);
   //     }
    }
}
