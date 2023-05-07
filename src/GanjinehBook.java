public class GanjinehBook extends Book{
    private String donor;

    public GanjinehBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, String donor, String category) {
        super(sourceId, title, author, publisher, yearOfPublishing, category);
        this.donor = donor;
    }
}
