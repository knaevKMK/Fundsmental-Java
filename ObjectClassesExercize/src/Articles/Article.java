package Articles;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void renameTitle(String newTitle) {
        this.title = newTitle;
    }

    public void editContent(String newContent) {
        this.content = newContent;
    }

    public void changAutor(String newAuthor) {
        this.author = newAuthor;
    }


    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }
}
