import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line= scanner.nextLine();
        String regexEmail= "\\s" +
                "(?<user>[A-Za-z0-9]+[-._]?[A-Za-z\\d]*@{1})" +
                "(?<host>[a-z]+(-[a-z]+)?(\\.{1}[a-z]+){1,2})\\b";
        Pattern pattern=Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
            System.out.println(matcher.group("user")+matcher.group("host"));
        }
    }
}
