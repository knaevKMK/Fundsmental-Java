import java.util.Locale;
import java.util.Scanner;

public class Ex1 {
    private static Scanner scanner = new Scanner(System.in);
    private static String text = scanner.nextLine();


    public static void main(String[] args) {
        String read;
        while (!"For Azeroth".equals(read = scanner.nextLine())) {
            String[] data = read.split(" ");
            String command = data[0];


            switch (command) {
                case "GladiatorStance":
                    text = text.toUpperCase();
                    printResult(text);
                    break;
                case "DefensiveStance":
                    text = text.toLowerCase();
                    printResult(text);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(data[1]);

                    if (index < 0 || index >= text.length()) {
                        printResult("Dispel too weak.");
                    } else {
                        String letter = data[2];
                        StringBuilder temp = new StringBuilder(text);
                        temp.deleteCharAt(index);
                        temp.insert(index, letter);
                        text = temp.toString();
//                        String temp = text.charAt(index) + "";
//                        text = text.replace(temp, letter);
                        printResult("Success!");
                    }
                    break;
                case "Target":
                    String reCommand = data[1];
                    String subStr = data[2];
                    if (text.contains(subStr)) {
                        if (reCommand.equals("Change")) {
                            String toReplace = data[3];
                            text = text.replaceAll(subStr, toReplace);
                            printResult(text);
                        } else if (reCommand.equals("Remove")) {
                            text = text.replaceAll(subStr, "");
                            printResult(text);
                        } else {
                            printResult("Command doesn't exist!");
                        }

                    } else {
                        printResult("Command doesn't exist!");
                    }
                    break;
                default:
                    printResult("Command doesn't exist!");
                    break;
            }
        }
    }


    private static void printResult(String s) {
        System.out.println(s);
    }
}
