public interface Borrower {
    public final int MAX_SOURCES_STUDENT_CAN_BORROW = 3;
    public final int MAX_HOURS_BOOK_STUDENT = 240;
    public final int MAX_HOURS_THESIS_STUDENT = 7*24;
     public final int MAX_SOURCES_STAFF_CAN_BORROW = 5;
    public final int MAX_HOURS_BOOK_STAFF = 14*24;
    public final int MAX_HOURS_THESIS_STAFF = 240;


    public int getCountOfBorrowedSources();
    boolean canBorrow(Source source, String date, String time);
    abstract void borrow(String libraryId, String sourceId, String date, String time);
}
