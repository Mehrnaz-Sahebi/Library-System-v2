public class Book extends Source{
    private String publisher;
    private int yearOfPublishing;

    public Book(String sourceId, String title, String author, String publisher, int yearOfPublishing, String category) {
        super(sourceId, title, author, category);
        this.publisher = publisher;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getPublisher() {
        return publisher;
    }
}
