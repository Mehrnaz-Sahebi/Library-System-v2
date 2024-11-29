import java.util.ArrayList;
import java.util.HashSet;

public class Library {
    private final String libraryId;
    private final String name;
    private final int yearOfEstablishment;
    private final int countOfDesks;
    private final String address;
    private HashSet<Source> sources;


    public Library(String libraryId, String name, int yearOfEstablishment, int countOfDesks, String address) {
        this.libraryId = libraryId;
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.countOfDesks = countOfDesks;
        this.address = address;
        this.sources = new HashSet<Source>();
    }

    public String getLibraryId() {
        return libraryId;
    }

    public HashSet<Source> getSources() {
        return sources;
    }

    public Source getSource(String sourceId) {
        for (Source source : sources) {
            if (source.getSourceId().equals(sourceId)) {
                return source;
            }
        }
        return null;
    }

    public boolean doesSourceExist(String sourceId) {
        if (this.getSource(sourceId) == null) {
            return false;
        }
        return true;
    }

    public void addNormalBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, int numberOfCopies, String category) {
        NormalBook newNormalBook = new NormalBook(sourceId, title, author, publisher, yearOfPublishing, numberOfCopies, category);
        sources.add(newNormalBook);
    }

    public void addThesis(String sourceId, String title, String author, String supervisor, int yearOfDefence, String category) {
        Thesis newThesis = new Thesis(sourceId, title, author, supervisor, yearOfDefence, category);
        sources.add(newThesis);
    }

    public void addGanjinehBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, String donor, String category) {
        GanjinehBook newGanjinehBook = new GanjinehBook(sourceId, title, author, publisher, yearOfPublishing, donor, category);
        sources.add(newGanjinehBook);
    }

    public void addSellingBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, int numberOfCopies, long price, int discount, String category) {
        SellingBook newSellingBook = new SellingBook(sourceId, title, author, publisher, yearOfPublishing, numberOfCopies, price, discount, category);
        sources.add(newSellingBook);
    }

    public void removeSource(String sourceId) {
        sources.remove(this.getSource(sourceId));
    }

    public boolean canSourceBeBorrowed(String sourceId) {
        Source source = getSource(sourceId);
        if (source instanceof SellingBook || source instanceof GanjinehBook) {
            return false;
        }
        if (source instanceof NormalBook) {
            if (((NormalBook) source).getRemaining() <= 0) {
                return false;
            }
        }
        if (source instanceof Thesis) {
            if (((Thesis) source).isBorrowed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSourceBorrowed(String sourceId) {
        Source source = getSource(sourceId);
        if (source instanceof NormalBook) {
            if (((NormalBook) source).getRemaining() != ((NormalBook) source).getCountOfCopies()) {
                return true;
            }
        }
        if (source instanceof Thesis) {
            if (((Thesis) source).isBorrowed()) {
                return true;
            }
        }
        return false;
    }

    public boolean canSourceBeBought(String sourceId) {
        Source source = getSource(sourceId);
        if (!(source instanceof SellingBook)) {
            return false;
        } else if (source instanceof SellingBook && ((SellingBook) source).getRemaining() <= 0) {
            return false;
        }
        return true;
    }

    public boolean canSourceBeRead(String sourceId, String date, String time) {
        Source source = getSource(sourceId);
        if (source instanceof GanjinehBook && ((GanjinehBook) source).canBookBeRead(date, time)) {
            return true;
        }
        return false;
    }

    public void categoryReport(HashSet<String> categoriesToCheck) {
        int countOfNormalBooks = 0;
        int countOfGanjinehBooks = 0;
        int countOfSellingBooks = 0;
        int countOfTheses = 0;
        for (String categoryToCheck :categoriesToCheck){
            for (Source source : sources) {
                if (source.getCategory().equals(categoryToCheck)) {
                    if (source instanceof NormalBook) {
                        countOfNormalBooks += ((NormalBook) source).getRemaining();
                    } else if (source instanceof GanjinehBook) {
                        countOfGanjinehBooks += 1;
                    } else if (source instanceof SellingBook) {
                        countOfSellingBooks += ((SellingBook) source).getRemaining();
                    } else if(source instanceof Thesis){
                        if(!((Thesis) source).isBorrowed()) {
                            countOfTheses += 1;
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d %d %d\n", countOfNormalBooks, countOfTheses , countOfGanjinehBooks, countOfSellingBooks);
    }
}
