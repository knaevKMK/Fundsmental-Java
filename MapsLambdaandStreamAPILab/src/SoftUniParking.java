import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> regParkList = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s", 2);
            switch (tokens[0]) {
                case "register":
                    String[] data = tokens[1].split("\\s", 2);
                    if (check(data[0], regParkList)) {
                        System.out.println("ERROR: already registered with plate number " + data[1]);
                    } else {
                        regParkList.put(data[0], data[1]);
                        System.out.println(data[0] + " registered " + data[1] + " successfully");
                    }
                    break;
                case "unregister":
                    if (check(tokens[1], regParkList)) {
                        regParkList.remove(tokens[1]);
                        System.out.println(tokens[1] + " unregistered successfully");
                    } else {
                        System.out.println("ERROR: user " + tokens[1] + " not found");
                    }
                    break;
            }
        }
        regParkList.forEach((a, b) -> System.out.println(a + " => " + b));
    }

    private static boolean check(String name, Map<String, String> regParkList) {
        return regParkList.containsKey(name);
    }
}
