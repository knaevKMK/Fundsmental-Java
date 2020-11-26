import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().replaceAll("\\s+", "").split(",");

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String left = (getWinCombination(ticket.substring(0, 10)));
            String right = (getWinCombination(ticket.substring(10, 20)));

            if (left.equals("notFound") || right.equals("notFound")) {
                System.out.println("ticket \"" + ticket + "\" - no match");
                continue;
            }
            int length = left.length() < right.length() ? left.length() : right.length();
            String jackpot = getJacpot(length);
            System.out.println("ticket \"" + ticket + "\" - " + length + left.substring(0, 1) + "" + jackpot);
        }
    }

    private static String getWinCombination(String side) {
        String regexWinner = "(?<win>([@#$^])\\2{5,})";
        Pattern pattern = Pattern.compile(regexWinner);
        Matcher matcher = pattern.matcher(side);
        if (matcher.find()) {
            return matcher.group();
        }
        return "notFound";
    }

    private static String getJacpot(int length) {
        if (length == 10) {
            return " Jackpot!";
        }
        return "";
    }
}
