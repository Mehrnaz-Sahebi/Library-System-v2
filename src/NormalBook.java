public class NormalBook extends Book {
    private int countOfCopies;
    private int remaining;

    public NormalBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, int countOfCopies, String category) {
        super(sourceId, title, author, publisher, yearOfPublishing, category);
        this.countOfCopies = countOfCopies;
        this.remaining = countOfCopies;
    }

    public int getRemaining() {
        return remaining;
    }
}
