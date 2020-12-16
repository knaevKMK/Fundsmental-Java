import java.util.Scanner;

public class WorldTour {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder line = new StringBuilder(scanner.nextLine());
        String read;
        while (!"Travel".equals(read = scanner.nextLine())) {
            String[] data = read.split(":");
            String one = data[1];
            String two = data[2];
            switch (data[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(one);
                    if (index >= 0 && index < line.length()) {
                        String toInsert = data[2];
                        line.insert(index, toInsert);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(one);
                    int endIndex = Integer.parseInt(two);
                    if (startIndex >= 0 && startIndex <= endIndex && endIndex < line.length()) {
                        line.delete(startIndex, endIndex+1);
                    }
                    break;
                case "Switch":
                    if (line.indexOf(one) >= 0) {
                        line = new StringBuilder(line.toString().replace(one, two));
                    }
                    break;
                default:continue;
            }
            print(line.toString());
        }
        print("Ready for world tour! Planned stops: " + line);
    }

    private static void print(String read) {
        System.out.println(read);
    }
}