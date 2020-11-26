import java.util.Scanner;

public class CenturiestoMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte centurie = Byte.parseByte(scanner.nextLine());
        int year = centurie * 100;
        int day = (int) (year * 365.2422);
        long hour = day * 24;
        long min = hour * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centurie, year, day, hour, min);
        //System.out.println(centurie + " centuries = " + year + " years = " + day + " days = " + hour + " hours = " + min + " minutes");
    }
}
