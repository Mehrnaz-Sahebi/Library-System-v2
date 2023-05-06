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
        if (librarySystem.doesUserExist(3)) {
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
        if (librarySystem.doesUserExist(3)) {
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


}
