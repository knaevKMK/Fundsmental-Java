import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern names = Pattern.compile("\\b([A-Z][a-z]+)( )([A-Z][a-z]+)\\b");
        Matcher matcher = names.matcher(line);
        while (matcher.find()){
            System.out.print(matcher.group()+" ");
        }
    }
}
