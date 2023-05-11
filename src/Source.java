import java.util.ArrayList;

public class Source {
    private String sourceId;
    private String title;
    private String author;

    private String category;
    private ArrayList<String> comments;

    public Source(String sourceId, String title, String author, String category) {
        this.sourceId = sourceId;
        this.title = title;
        this.author = author;
        this.category = category;
        comments = new ArrayList<String>();
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public void recieveAComment(String comment){
        comments.add(comment);
    }
}
