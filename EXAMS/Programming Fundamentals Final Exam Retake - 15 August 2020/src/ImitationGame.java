import java.util.Scanner;

public class ImitationGame {
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder text;

    public static void main(String[] args) {
        text = new StringBuilder(scanner.nextLine());
        String read;
        while (!"Decode".equals(read = scanner.nextLine())) {
            String[] data = read.split("\\|");

            switch (data[0]) {
                case "Move":
                    int countChar = Integer.parseInt(data[1]);
                    String temp = text.substring(0, countChar);
                    text.delete(0, countChar);
                    text.append(temp);
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(data[1]);
                    String insert = data[2];
                    text.insert(indexInsert, insert);
                    break;
                case "ChangeAll":
                    String old = data[1];
                    String replacemnet = data[2];
            temp = text.toString();
                    if (temp.contains(old)) {
                        temp = temp.replace(old, replacemnet);
                        text = new StringBuilder(temp);
                    }
                    break;
            }
        }
        System.out.println("The decrypted message is: " + text.toString());
    }
}
