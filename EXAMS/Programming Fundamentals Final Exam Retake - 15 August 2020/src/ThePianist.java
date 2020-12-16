import com.sun.source.tree.IfTree;

import java.util.*;

public class ThePianist {
    private static Scanner scanner = new Scanner(System.in);

    private static class Song {
        private String name;
        private String composer;
        private String key;

        public Song(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Song> list = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            String name = data[0];
            String composer = data[1];
            String key = data[2];
            list.put(name, new Song(name, composer, key));
        }

        String read;
        while (!"Stop".equals(read = scanner.nextLine())) {
            String[] data = read.split("\\|");
            String name = data[1];
            switch (data[0]) {
                case "Add":

                    String compose = data[2];
                    String key = data[3];
                    if (list.containsKey(name)) {
                        System.out.println(name + " is already in the collection!");
                        break;
                    }
                    list.put(name, new Song(name, compose, key));
                    System.out.println(String.format("%s by %s in %s added to the collection!", name, compose, key));
                    break;
                case "Remove":
                    if (!list.containsKey(name)) {
                        System.out.println("Invalid operation! " + name + " does not exist in the collection.");
                    } else {
                        list.remove(name);
                        System.out.println("Successfully removed " + name + "!");
                    }
                    break;
                case "ChangeKey":
                    if (!list.containsKey(name)) {
                        System.out.println("Invalid operation! " + name + " does not exist in the collection.");
                        break;
                    }
                    key = data[2];
                    list.get(name).setKey(key);
                    System.out.println("Changed the key of " + name + " to " + key + "!");
                    break;
            }
        }
        list.values().stream().sorted((a, b) -> {
            int result = a.getName().compareTo(b.getName());
            if (result == 0) {
                result = a.getComposer().compareTo(b.getComposer());
            }
            return result;
        }).forEach(song -> System.out.println(String.format("%s -> Composer: %s, Key: %s", song.getName(), song.getComposer(), song.getKey())));
    }
}
