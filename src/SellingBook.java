public class SellingBook extends Book{
    private int countOfCopies;
    private long price;
    private int discount;

    public SellingBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, int countOfCopies, long price, int discount, String category) {
        super(sourceId, title, author, publisher, yearOfPublishing, category);
        this.countOfCopies = countOfCopies;
        this.price = price;
        this.discount = discount;
    }
}
