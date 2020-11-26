package OrderbyAge;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<People> person = new ArrayList<>();

        String read = scanner.nextLine();
        while (!"End".equals(read)) {
            String[] token = read.split("\\s+");
            String name = token[0];
            String id = token[1];
            int age = Integer.parseInt(token[2]);

            People personRead = new People(name, id, age);
            person.add(personRead);

            read = scanner.nextLine();
        }
        person.sort(Comparator.comparing(People::getAge));
        for (People people : person) {
            System.out.println(people.toString());
        }
    }
}
