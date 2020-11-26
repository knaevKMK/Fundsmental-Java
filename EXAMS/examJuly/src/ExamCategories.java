import java.util.Scanner;

public class ExamCategories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int difficult = Integer.parseInt(scanner.nextLine());
        int screw = Integer.parseInt(scanner.nextLine());
        int page = Integer.parseInt(scanner.nextLine());
        String type = "";

        if (difficult >= 80) {
            if (screw >= 80) {
                if (page >= 8) {
                    type = "Legacy";
                } else if ( page>=2){
                    type = "Hard";
                }else {
                    type = "Regular";
                }
            } else if (screw >= 50) {
                if (page >= 2) {
                    type = "Hard";
                } else {
                    type = "Regular";
                }
            } else if (screw < 50 & screw > 10) {
                type = "Regular";
            } else if (screw <= 10) {
                type = "Master";
            }

        } else if (difficult < 80 && difficult > 30) {
            if (screw >= 50 && page >= 2) {
                type = "Hard";
            } else {
                type = "Regular";
            }

        } else if (difficult <= 30 && difficult>10) {
            if (screw >= 50 && page >= 2) {
                type = "Hard";
            } else if (page <= 1) {
                type = "Easy";
            } else {
                type = "Regular";
            }

        } else if (difficult <= 10) {
            if (screw >= 50 && page >= 2) {
                type = "Hard";
            } else {
                type = "Elementary";
            }
        }
        System.out.println(type);
    }
}
