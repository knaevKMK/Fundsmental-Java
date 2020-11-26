package Articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String currentTitle = input[0];
        String currentContent = input[1];
        String currentAutor = input[2];
        Article article = new Article(currentTitle, currentContent, currentAutor);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] token = scanner.nextLine().split(": ");
            String command = token[0];
            String data = token[1];
            switch (command) {
                case "Edit":
                    article.editContent(data);
                    break;
                case "ChangeAuthor":
                    article.changAutor(data);
                    break;
                case "Rename":
                    article.renameTitle(data);
                    break;
            }

        }
        System.out.println(article.toString());
    }

}
