public class GanjinehBook extends Book{
    private int yearOfPublishing;
    private String donor;

    public GanjinehBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, String donor, String category) {
        super(sourceId, title, author, publisher, category);
        this.yearOfPublishing = yearOfPublishing;
        this.donor = donor;
    }
}
