import java.util.Date;

public class Borrowing {
    private String userId;
    private String libraryId;
    private String sourceId;
    private Date borrowingTime;

    public Borrowing(String userId, String libraryId, String sourceId, String date, String time) {
        this.userId = userId;
        this.libraryId = libraryId;
        this.sourceId = sourceId;
        String[] partsOfDate = date.split("-");
        String[] partsOfTime = time.split(":");
        this.borrowingTime = new Date(Integer.parseInt(partsOfDate[0])-1900, Integer.parseInt(partsOfDate[1])-1,Integer.parseInt(partsOfDate[2]),Integer.parseInt(partsOfTime[0]),Integer.parseInt(partsOfTime[1]));
    }

    public String getSourceId() {
        return sourceId;
    }

    public Date getBorrowingTime() {
        return borrowingTime;
    }

    public String getLibraryId() {
        return libraryId;
    }
}
