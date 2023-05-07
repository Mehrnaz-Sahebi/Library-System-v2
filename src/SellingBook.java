public class SellingBook extends Book{
    private int numberOfCopies;
    private long price;
    private int discount;

    public SellingBook(String sourceId, String title, String author, String publisher, int numberOfCopies, long price, int discount, String category) {
        super(sourceId, title, author, publisher, category);
        this.numberOfCopies = numberOfCopies;
        this.price = price;
        this.discount = discount;
    }
}
