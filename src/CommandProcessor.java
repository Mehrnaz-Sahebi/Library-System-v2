public class CommandProcessor {
    public static void addLibrary(String[] poc, LibrarySystem librarySystem){
        if(librarySystem.doesLibraryExist(poc[3])){
            System.out.println("duplicate-id");
        }
        else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        }
        else if(!librarySystem.isUserAdmin(poc[1])){
            System.out.println("permission-denied");
        }
        else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        }
        else {
            System.out.println("success");
        }
    }
    public static void addCategory(String[] poc, LibrarySystem librarySystem){
        if(librarySystem.doesCategoryExist(poc[3])){
            System.out.println("duplicate-id");
        }
        else if(!librarySystem.doesCategoryExist(poc[5])&&!poc[5].equals("null")){
            System.out.println("not-found");
        }
        else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        }
        else if(!librarySystem.isUserAdmin(poc[1])){
            System.out.println("permission-denied");
        }
        else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        }
        else {
            System.out.println("success");
        }
    }


}
