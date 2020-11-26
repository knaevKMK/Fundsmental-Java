import javax.swing.*;
import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> comanies = new TreeMap<>();
        String read = scanner.nextLine();
        while (!"End".equals(read)) {
            String[] token = read.split(" -> ");
            comanies.putIfAbsent(token[0], new ArrayList<String>());
            addCompanies(token, comanies);

            read = scanner.nextLine();
        }
        comanies
                .entrySet()
                .forEach(a ->
                {
                    System.out.println(a.getKey());
                    a
                            .getValue()
                            .forEach(id -> System.out.println("-- " + id));
                });

    }

    private static void addCompanies(String[] token, Map<String, ArrayList<String>> list) {
        if (!list.get(token[0]).contains(token[1])) {
            list.get(token[0]).add(token[1]);
        }
    }
}
