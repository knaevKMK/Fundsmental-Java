package Articles2;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<ArticleA> articleAS = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];
            ArticleA articleA = new ArticleA(title, content, author);
            articleAS.add(articleA);
        }
        String reason = scanner.nextLine();
        switch (reason) {
            case "title":
                articleAS.sort(Comparator.comparing(ArticleA::getTitle));
                break;
            case "content":
                articleAS.sort(Comparator.comparing(ArticleA::getContent));
                break;
            case "author":
                articleAS.sort(Comparator.comparing(ArticleA::getAuthor));
                break;
        }
        for (ArticleA articleA : articleAS) {
            System.out.println(articleA.toString());
        }
    }
}
