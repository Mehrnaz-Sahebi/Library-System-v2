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
            command = scanner.nextLine();
            poc= command.split("[#|]+");
        }
    }
}
