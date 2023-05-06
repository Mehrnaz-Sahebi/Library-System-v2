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
            if(poc[0].equals("add-category")){
                CommandProcessor.addCategory(poc, librarySystem);
            }
        }
    }
}
