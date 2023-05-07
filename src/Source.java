public class Source {
    private String sourceId;
    private String title;
    private String author;

    private String category;

    public Source(String sourceId, String title, String author, String category) {
        this.sourceId = sourceId;
        this.title = title;
        this.author = author;
        this.category = category;
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
}
