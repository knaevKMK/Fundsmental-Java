import java.util.Scanner;

public class ActivationKeys {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        String read;
        while (!"Generate".equals(read = scanner.nextLine())) {
            String[] tokens = read.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    if (!input.contains(tokens[1])) {
                        System.out.println("Substring not found!");
                        continue;
                    }
                    System.out.println(input + " contains " + tokens[1]);

                    break;
                case "Flip":
                    //o	All given indexes will be valid.
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    switch (tokens[1]) {
                        case "Upper":
                            input = input.substring(0, startIndex) + input.substring(startIndex, endIndex).toUpperCase()
                                    + input.substring(endIndex);
                            break;
                        case "Lower":
                            input = input.substring(0, startIndex) + input.substring(startIndex, endIndex).toLowerCase()
                                    + input.substring(endIndex);
                            break;
                    }
                    System.out.println(input);


                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    //o	Deletes the characters between the start and end indices (end index is exclusive).
                    StringBuilder temp = new StringBuilder(input);
                    temp.delete(startIndex, endIndex);
                    input = temp.toString();
                    System.out.println(input);
                    break;
            }
        }
        System.out.println("Your activation key is: " + input);

    }
}
