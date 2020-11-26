import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("<h1>%n    %s%n</h1>", scanner.nextLine()));
        System.out.println(String.format("<article>%n    %s%n</article>", scanner.nextLine()));

        String comments = scanner.nextLine();
        while (!"end of comments".equals(comments)) {
            System.out.println(String.format("<div>%n    %s%n</div>", comments));

            comments = scanner.nextLine();
        }


    }
}
