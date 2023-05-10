import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Staff extends User implements Borrower{
    private HashSet<Borrowing> borrowings;
    public Staff(String id, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address){
        super(id, password, firstName, lastName, nationalId, yearOfBirth, address);
        this.borrowings = new HashSet<Borrowing>();
    }
    @Override
    public int getCountOfBorrowedSources(){
        return borrowings.size();
    }
    @Override
    public boolean canBorrow(Source source, String date, String time){
        if(getCountOfBorrowedSources()>=MAX_SOURCES_STAFF_CAN_BORROW){
            return false;
        }
        String[] partsOfDate = date.split("-");
        String[] partsOfTime = time.split(":");
        Date now = new Date(Integer.parseInt(partsOfDate[0])-1900, Integer.parseInt(partsOfDate[1])-1,Integer.parseInt(partsOfDate[2]),Integer.parseInt(partsOfTime[0]),Integer.parseInt(partsOfTime[1]));
        for (Borrowing borrowing:borrowings) {
            if(borrowing.getSourceId().equals(source.getSourceId())){
                return false;
            }
            long differenceOFDays = now.getTime() - borrowing.getBorrowingTime().getTime();
            differenceOFDays = TimeUnit.HOURS.convert(differenceOFDays, TimeUnit.MILLISECONDS);
            if(source instanceof NormalBook && differenceOFDays>MAX_HOURS_BOOK_STAFF || source instanceof Thesis && differenceOFDays>MAX_HOURS_THESIS_STAFF){
                return false;
            }
        }
        return true;
    }
    @Override
    public void borrow(String libraryId, String sourceId, String date, String time){
        Borrowing borrowing = new Borrowing(this.getUserId(),libraryId,sourceId,date,time);
        borrowings.add(borrowing);
    }
}
