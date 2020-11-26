import java.util.*;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String read = scanner.nextLine();
        Map<String, Integer> dwarf = new TreeMap<>(); // hatColor, <name, physics>

        while (!"Once upon a time".equals(read)) {
            String[] token = read.split(" <:> ");
            String name = token[0];
            String hatColor = token[1];
            int physics = Integer.parseInt(token[2]);
            addInMap(name, hatColor, physics, dwarf);
            read = scanner.nextLine();
        }
        dwarf
                .entrySet()
                .stream()
                .sorted((a1, a2) -> {
                    int result = a2.getValue().compareTo(a1.getValue());
                    if (result == 0) {
                        String[] ramOne = a1.getKey().split("\\) ");
                        String[] ramTwo = a2.getKey().split("\\) ");

                        if (result == 0) {
                            result = ramTwo[1].compareTo(ramOne[1]);
                        }
                    }
                    return result;
                }).forEach(a -> System.out.println("(" + a.getKey() + " <-> " + a.getValue()));

    }

    private static int checkCount(String[] ram, Map<String, Integer> dwarf) {
        int count = 0;
        for (String s : dwarf.keySet()) {
            boolean flag = true;
            for (int i = 0; i < ram[0].length(); i++) {
                if (s.charAt(i) == ram[0].charAt(i)) {
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    private static void addInMap(String name, String hatColor, int physics, Map<String, Integer> dwarf) {
        String check = hatColor + ")" + " " + name;
        dwarf.putIfAbsent(check, physics);
        if (dwarf.containsKey(check) && dwarf.get(check) < physics) {
            dwarf.put(check, physics);
        }


    }
}
