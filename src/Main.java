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

            }
            //add-book
            else if(poc[0].equals("add-book")){
                CommandProcessor.
            }

        }
    }
}
