public class NormalBook extends Book {
    private int numberOfCopies;

    public NormalBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, int numberOfCopies, String category) {
        super(sourceId, title, author, publisher, yearOfPublishing, category);
        this.numberOfCopies = numberOfCopies;
    }
}
