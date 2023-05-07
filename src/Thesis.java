public class Thesis extends Source {
    private String supervisor;
    private int yearOfDefence;

    public Thesis(String sourceId, String title, String author, String supervisor, int yearOfDefence, String category) {
        super(sourceId, title, author, category);
        this.supervisor = supervisor;
        this.yearOfDefence = yearOfDefence;
    }
}
