import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GanjinehBook extends Book{
    private String donor;
    private Date lastRead;

    public GanjinehBook(String sourceId, String title, String author, String publisher, int yearOfPublishing, String donor, String category) {
        super(sourceId, title, author, publisher, yearOfPublishing, category);
        this.donor = donor;
        lastRead = new Date(0,0,0,0,0);
    }

    public Date getLastRead() {
        return lastRead;
    }

    public void setLastRead(Date lastRead) {
        this.lastRead = lastRead;
    }

    public boolean canBookBeRead(String date, String time){
        String[] partsOfDate = date.split("-");
        String[] partsOfTime = time.split(":");
        Date now = new Date(Integer.parseInt(partsOfDate[0])-1900, Integer.parseInt(partsOfDate[1])-1,Integer.parseInt(partsOfDate[2]),Integer.parseInt(partsOfTime[0]),Integer.parseInt(partsOfTime[1]));
        long differenceOFDays = now.getTime() - getLastRead().getTime();
        differenceOFDays = TimeUnit.MINUTES.convert(differenceOFDays, TimeUnit.MILLISECONDS);
        if(differenceOFDays<120){
            return false;
        }
        return true;
    }
}
