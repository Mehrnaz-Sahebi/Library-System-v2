import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[] poc= command.split("[#|]+");
        while(!poc[0].equals("finish")){
            //add-library
            if(poc[0].equals("add-library")){
                CommandProcessor.addLibrary(poc, librarySystem);
            }
            //add-category
            else if(poc[0].equals("add-category")){
                CommandProcessor.addCategory(poc, librarySystem);
            }
            //add-student
            else if(poc[0].equals("add-student")){
                CommandProcessor.addStudent(poc, librarySystem);
            }
            //add-Staff
            else if(poc[0].equals("add-staff")){
                CommandProcessor.addStaff(poc, librarySystem);
            }
            //add-manager
            else if(poc[0].equals("add-manager")){
                CommandProcessor.addManager(poc, librarySystem);
            }
            //remove-user
            else if (poc[0].equals("remove-user")) {
                CommandProcessor.removeUser(poc, librarySystem);
            }
            //add-book
            else if(poc[0].equals("add-book")){
                CommandProcessor.addBook(poc,librarySystem);
            }
            //add-thesis
            else if (poc[0].equals("add-thesis")) {
                CommandProcessor.addThesis(poc,librarySystem);
            }
            //add-ganjineh-book
            else if (poc[0].equals("add-ganjineh-book")) {
                CommandProcessor.addGanjinehBook(poc,librarySystem);
            }
            //add-selling-book
            else if (poc[0].equals("add-selling-book")) {
                CommandProcessor.addSellingBook(poc,librarySystem);
            }
            //remove-resource
            else if (poc[0].equals("remove-resource")) {
                CommandProcessor.removeResource(poc, librarySystem);
            }
            //borrow
            else if (poc[0].equals("borrow")) {
                CommandProcessor.borrow(poc, librarySystem);
            }
            //return
            else if (poc[0].equals("return")) {
                CommandProcessor.returning(poc,librarySystem);
            }
            //buy
            else if(poc[0].equals("buy")){
                CommandProcessor.buy(poc,librarySystem);
            }
            //read
            else if (poc[0].equals("read")) {
                CommandProcessor.read(poc,librarySystem);
            }
            //add-comment
            else if (poc[0].equals("add-comment")) {
                CommandProcessor.addComment(poc,librarySystem);
            }
            //search
            else if (poc[0].equals("search")){
                CommandProcessor.search(poc ,librarySystem);
            }
            //search-user
            else if (poc[0].equals("search-user")) {
                CommandProcessor.searchUser(poc,librarySystem);
            }
            //category-report
            else if (poc[0].equals("category-report")) {
                CommandProcessor.categoryReport(poc ,librarySystem);
            }
            //library-report
            else if (poc[0].equals("library-report")) {
                CommandProcessor.libraryReport(poc , librarySystem);
            }
            //library-report
            else if (poc[0].equals("library-report")) {
                CommandProcessor.libraryReport(poc , librarySystem);
            }
            //report-passed-deadline
            else if (poc[0].equals("report-passed-deadline")) {
                CommandProcessor.reportPassedDeadline(poc , librarySystem);
            }
            //report-penalties-sum
            else if (poc[0].equals("report-penalties-sum")) {
                CommandProcessor.reportPenaltiesSum(poc , librarySystem);
            }

            command = scanner.nextLine();
            poc= command.split("[#|]+");
        }
    }
}
