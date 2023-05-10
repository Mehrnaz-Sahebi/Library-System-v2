public interface Borrower {
    public final int MAX_SOURCES_STUDENT_CAN_BORROW = 3;
    public final int MAX_HOURS_BOOK_STUDENT = 240;
    public final int MAX_HOURS_THESIS_STUDENT = 7*24;
     public final int MAX_SOURCES_STAFF_CAN_BORROW = 5;
    public final int MAX_HOURS_BOOK_STAFF = 14*24;
    public final int MAX_HOURS_THESIS_STAFF = 240;
    public final int STUDENT_PENALTY_FOR_AN_HOUR = 50;
    public final int STAFF_PENALTY_FOR_AN_HOUR = 100;


    public int getCountOfBorrowedSources();

    abstract boolean canBorrow(String libraryId, Source source, String date, String time);

    public void borrow(String libraryId, String sourceId, String date, String time);
    public void addToDebt(long newDebt);
    public boolean hasBorrowedSource(String libraryId, String sourceId);

    public long returns(String libraryId, Source source, String date, String time);
}
