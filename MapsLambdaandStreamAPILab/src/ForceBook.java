import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> side = new TreeMap<>();
        String read = scanner.nextLine();

        while (!"Lumpawaroo".equals(read)) {

            String separator = checkSeparator(read);
            String[] token = read.split(separator);
            switch (separator) {
                case " \\| ": //[0]- side [1]-member
                    if (!checkMameberExist(token[1], side)) {
                        side.putIfAbsent(token[0], new ArrayList<String>());
                    }
                    if (side.containsKey(token[0]) && !side.get(token[0]).contains(token[1])) {
                        addMemberInList(token[1], token[0], side);
                    }
                    break;
                case " -> "://[1]- side [0]-member
                    checkAndRemoveMember(token[0], side);

                    side.putIfAbsent(token[1], new ArrayList<String>());

                    addMemberInList(token[0], token[1], side);
                    System.out.println(String.format("%s joins the %s side!", token[0], token[1]));

                    break;
            }
            read = scanner.nextLine();
        }
        side.entrySet()
                .stream()
                .sorted((a1, a2) -> Integer.compare(a2.getValue().

                        size(), a1.

                        getValue().

                        size()))
                .

                        forEach(a ->

                        {
                            if (!a.getValue().isEmpty()) {
                                System.out.printf("Side: %s, Members: %d%n", a.getKey(), a.getValue().size());
                                a
                                        .getValue()
                                        .stream()
                                        .sorted((String::compareTo))
                                        .forEach(member -> System.out.println("! " + member));
                            }
                        });
    }

    private static boolean checkMameberExistInSameSide(String member, String sideName, Map<String, ArrayList<String>> side) {

        return side.get(sideName).contains(member);
    }

    private static boolean checkMameberExist(String member, Map<String, ArrayList<String>> side) {
        boolean exist = false;
        for (ArrayList<String> value : side.values()) {
            if (value.contains(member)) {
                exist = true;
            }
        }
        return exist;
    }

    private static void checkAndRemoveMember(String member, Map<String, ArrayList<String>> side) {
        for (ArrayList<String> value : side.values()) {
            if (value.contains(member)) {
                value.remove(member);
            }
        }
    }

    private static String checkSeparator(String read) {
        for (int i = 0; i < read.length(); i++) {
            if (read.charAt(i) == '|') {
                return " \\| ";
            } else if (String.format("%c%c", read.charAt(i), read.charAt(i + 1)).equals("->")) {
                return " -> ";
            }
        }

        return read;
    }

    private static void addMemberInList(String member, String sideName, Map<String, ArrayList<String>> side) {
        side.get(sideName).add(member);
    }

}
