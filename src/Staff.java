import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Staff extends User implements Borrower{
    private HashSet<Borrowing> borrowings;
    private long debt;
    public Staff(String id, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address){
        super(id, password, firstName, lastName, nationalId, yearOfBirth, address);
        this.borrowings = new HashSet<Borrowing>();
        debt = 0;
    }
    @Override
    public int getCountOfBorrowedSources(){
        return borrowings.size();
    }
    @Override
    public boolean canBorrow(String libraryId, Source source, String date, String time){
        if(getCountOfBorrowedSources()>=MAX_SOURCES_STAFF_CAN_BORROW){
            return false;
        }
        String[] partsOfDate = date.split("-");
        String[] partsOfTime = time.split(":");
        Date now = new Date(Integer.parseInt(partsOfDate[0])-1900, Integer.parseInt(partsOfDate[1])-1,Integer.parseInt(partsOfDate[2]),Integer.parseInt(partsOfTime[0]),Integer.parseInt(partsOfTime[1]));
        for (Borrowing borrowing:borrowings) {
            if(borrowing.getSourceId().equals(source.getSourceId()) && borrowing.getLibraryId().equals(libraryId)){
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
    @Override
    public boolean hasBorrowedSource(String libraryId, String sourceId){
        for (Borrowing borrowing:borrowings) {
            if(borrowing.getSourceId().equals(sourceId)&&borrowing.getLibraryId().equals(libraryId)){
                return true;
            }
        }
        return false;
    }
    public void setDebt(long debt) {
        this.debt = debt;
    }

    public long getDebt() {
        return debt;
    }

    @Override
    public void addToDebt(long newDebt){
        setDebt(getDebt()+newDebt);
    }
    @Override
    public long returns(String libraryId, Source source, String date, String time){
        String[] partsOfDate = date.split("-");
        String[] partsOfTime = time.split(":");
        long differenceOFDays = 0;
        Date returnTime = new Date(Integer.parseInt(partsOfDate[0])-1900, Integer.parseInt(partsOfDate[1])-1,Integer.parseInt(partsOfDate[2]),Integer.parseInt(partsOfTime[0]),Integer.parseInt(partsOfTime[1]));
        for (Borrowing borrowing:borrowings) {
            if(borrowing.getLibraryId().equals(libraryId)&&borrowing.getSourceId().equals(source.getSourceId())){
                differenceOFDays = returnTime.getTime() - borrowing.getBorrowingTime().getTime();
                differenceOFDays = TimeUnit.HOURS.convert(differenceOFDays, TimeUnit.MILLISECONDS);
                borrowings.remove(borrowing);
                break;
            }
        }
        if(source instanceof NormalBook && differenceOFDays<=MAX_HOURS_BOOK_STAFF){
            return 0;
        } else if (source instanceof NormalBook && differenceOFDays>MAX_HOURS_BOOK_STAFF) {
            long newDebt =(differenceOFDays-MAX_HOURS_BOOK_STAFF)*STAFF_PENALTY_FOR_AN_HOUR;
            addToDebt(newDebt);
            return newDebt;
        } else if (source instanceof Thesis && differenceOFDays<=MAX_HOURS_THESIS_STAFF){
            return 0;
        } else{// if(source instanceof Thesis && differenceOFDays>MAX_HOURS_THESIS_STAFF){
            long newDebt = (differenceOFDays-MAX_HOURS_THESIS_STAFF)*STAFF_PENALTY_FOR_AN_HOUR;
            addToDebt(newDebt);
            return newDebt;
        }
    }
}
