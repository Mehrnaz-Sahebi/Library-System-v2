public class CommandProcessor {
    public static void addLibrary(String[] poc, LibrarySystem librarySystem) {
        if (librarySystem.doesLibraryExist(poc[3])) {
            System.out.println("duplicate-id");
        } else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        } else if (!librarySystem.isUserAdmin(poc[1])) {
            System.out.println("permission-denied");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else {
            librarySystem.addLibrary(poc[3], poc[4], Integer.parseInt(poc[5]), Integer.parseInt(poc[6]), poc[7]);
            System.out.println("success");
        }
    }

    public static void addCategory(String[] poc, LibrarySystem librarySystem) {
        if (librarySystem.doesCategoryExist(poc[3])) {
            System.out.println("duplicate-id");
        } else if (!librarySystem.doesCategoryExist(poc[5]) && !poc[5].equals("null")) {
            System.out.println("not-found");
        } else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        } else if (!librarySystem.isUserAdmin(poc[1])) {
            System.out.println("permission-denied");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else {
            librarySystem.addCategory(poc[3], poc[4], poc[5]);
            System.out.println("success");
        }
    }

    public static void addStudent(String[] poc, LibrarySystem librarySystem) {
        if (librarySystem.doesUserExist(poc[3])) {
            System.out.println("duplicate-id");
        } else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        } else if (!librarySystem.isUserAdmin(poc[1])) {
            System.out.println("permission-denied");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else {
            librarySystem.addStudent(poc[3], poc[4], poc[5], poc[6], poc[7], Integer.parseInt(poc[8]), poc[9]);
            System.out.println("success");
        }
    }

    public static void addStaff(String[] poc, LibrarySystem librarySystem) {
        if (librarySystem.doesUserExist(poc[3])) {
            System.out.println("duplicate-id");
        } else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        } else if (!librarySystem.isUserAdmin(poc[1])) {
            System.out.println("permission-denied");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else {
            if (poc[10].equals("staff")) {
                librarySystem.addStaff(poc[3], poc[4], poc[5], poc[6], poc[7], Integer.parseInt(poc[8]), poc[9]);
            } else {
                librarySystem.addProfessor(poc[3], poc[4], poc[5], poc[6], poc[7], Integer.parseInt(poc[8]), poc[9]);
            }
            System.out.println("success");
        }
    }
    public static void addManager(String[] poc, LibrarySystem librarySystem) {
        if (librarySystem.doesUserExist(poc[3])) {
            System.out.println("duplicate-id");
        } else if (!librarySystem.doesLibraryExist(poc[10])) {
            System.out.println("not-found");
        } else if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        } else if (!librarySystem.isUserAdmin(poc[1])) {
            System.out.println("permission-denied");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else {
            librarySystem.addManager(poc[3], poc[4], poc[5], poc[6], poc[7], Integer.parseInt(poc[8]), poc[9],poc[10]);
            System.out.println("success");
        }
    }
    public static void removeUser(String[] poc, LibrarySystem librarySystem) {
        if (!librarySystem.doesUserExist(poc[1])) {
            System.out.println("not-found");
        } else if (!librarySystem.isUserAdmin(poc[1])) {
            System.out.println("permission-denied");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else if (!librarySystem.doesUserExist(poc[3])) {
            System.out.println("not-found");
        }
        //not-allowed
        else {
            librarySystem.removeUser(poc[3]);
            System.out.println("success");
        }
    }
    public static void addBook(String[] poc, LibrarySystem librarySystem){
        if (!librarySystem.doesLibraryExist(poc[10])||!librarySystem.doesCategoryExist(poc[9])||!librarySystem.doesUserExist(poc[1])){
            System.out.println("not-found");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else if (!librarySystem.isUserManager(poc[1])) {
            System.out.println("permission-denied");
        } else if (!((Manager)librarySystem.getUser(poc[1])).getLibraryId().equals(poc[10])) {
            System.out.println("permission-denied");
        } else if (librarySystem.getLibrary(poc[10]).doesSourceExist(poc[3])){
            System.out.println("duplicate-id");
        }
        else {
            librarySystem.getLibrary(poc[10]).addNormalBook(poc[3],poc[4],poc[5],poc[6],Integer.parseInt(poc[7]),Integer.parseInt(poc[8]),poc[9]);
            System.out.println("success");
        }
    }
    public static void addThesis(String[] poc, LibrarySystem librarySystem){
        if (!librarySystem.doesLibraryExist(poc[9])||!librarySystem.doesCategoryExist(poc[8])||!librarySystem.doesUserExist(poc[1])){
            System.out.println("not-found");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else if (!librarySystem.isUserManager(poc[1])) {
            System.out.println("permission-denied");
        } else if (!((Manager)librarySystem.getUser(poc[1])).getLibraryId().equals(poc[9])) {
            System.out.println("permission-denied");
        } else if (librarySystem.getLibrary(poc[9]).doesSourceExist(poc[3])){
            System.out.println("duplicate-id");
        }
        else {
            librarySystem.getLibrary(poc[9]).addThesis(poc[3],poc[4],poc[5],poc[6],Integer.parseInt(poc[7]),poc[8]);
            System.out.println("success");
        }
    }
    public static void addGanjinehBook(String[] poc, LibrarySystem librarySystem){
        if (!librarySystem.doesLibraryExist(poc[10])||!librarySystem.doesCategoryExist(poc[9])||!librarySystem.doesUserExist(poc[1])){
            System.out.println("not-found");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else if (!librarySystem.isUserManager(poc[1])) {
            System.out.println("permission-denied");
        } else if (!((Manager)librarySystem.getUser(poc[1])).getLibraryId().equals(poc[10])) {
            System.out.println("permission-denied");
        } else if (librarySystem.getLibrary(poc[10]).doesSourceExist(poc[3])){
            System.out.println("duplicate-id");
        }
        else {
            librarySystem.getLibrary(poc[10]).addGanjinehBook(poc[3],poc[4],poc[5],poc[6],Integer.parseInt(poc[7]),poc[8],poc[9]);
            System.out.println("success");
        }
    }
    public static void addSellingBook(String[] poc, LibrarySystem librarySystem){
        if (!librarySystem.doesLibraryExist(poc[12])||!librarySystem.doesCategoryExist(poc[11])||!librarySystem.doesUserExist(poc[1])){
            System.out.println("not-found");
        } else if (!librarySystem.getUser(poc[1]).getPassword().equals(poc[2])) {
            System.out.println("invalid-pass");
        } else if (!librarySystem.isUserManager(poc[1])) {
            System.out.println("permission-denied");
        } else if (!((Manager)librarySystem.getUser(poc[1])).getLibraryId().equals(poc[12])) {
            System.out.println("permission-denied");
        } else if (librarySystem.getLibrary(poc[12]).doesSourceExist(poc[3])){
            System.out.println("duplicate-id");
        }
        else {
            librarySystem.getLibrary(poc[12]).addSellingBook(poc[3],poc[4],poc[5],poc[6],Integer.parseInt(poc[7]),Integer.parseInt(poc[8]),Long.parseLong(poc[9]),Integer.parseInt(poc[10]),poc[11]);
            System.out.println("success");
        }
    }




}
