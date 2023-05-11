import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LibrarySystem {
    private HashSet<Library> libraries;
    private HashSet<User> users;
    private HashSet<Category> categories;

    public LibrarySystem(){
        libraries = new HashSet<Library>();
        users = new HashSet<User>();
        Admin ourAdmin = new Admin("admin","AdminPass");
        users.add(ourAdmin);
        categories = new HashSet<Category>();
        Category nullCategory = new Category("null","null","null");
        categories.add(nullCategory);
    }

    //user
    public void addStudent(String id, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address){
        Student newStudent = new Student(id,password,firstName,lastName,nationalId,yearOfBirth,address);
        users.add(newStudent);
    }
    public void addStaff(String id, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address){
        Staff newStaff = new Staff(id,password,firstName,lastName,nationalId,yearOfBirth,address);
        users.add(newStaff);
    }
    public void addProfessor(String id, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address){
        Professor newProfessor = new Professor(id,password,firstName,lastName,nationalId,yearOfBirth,address);
        users.add(newProfessor);
    }
    public void addManager(String id, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address, String libraryId){
        Manager newManager = new Manager(id,password,firstName,lastName,nationalId,yearOfBirth,address,libraryId);
        users.add(newManager);
    }

    public User getUser(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }
    public boolean doesUserExist(String userId){
        if(this.getUser(userId)==null){
            return false;
        }
        return true;
    }
    public boolean isUserAdmin(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)&& user instanceof Admin){
                return true;
            }
        }
        return false;
    }
    public boolean isUserManager(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)&& user instanceof Manager){
                return true;
            }
        }
        return false;
    }
    public boolean isUserProfessor(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)&& user instanceof Professor){
                return true;
            }
        }
        return false;
    }
    public boolean isUserStaff(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)&& user instanceof Staff){
                return true;
            }
        }
        return false;
    }
    public boolean isUserStudent(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)&& user instanceof Student){
                return true;
            }
        }
        return false;
    }
    public void removeUser(String userId){
        users.remove(this.getUser(userId));
    }
    public boolean canUserBorrow(String userId,String libraryId ,String sourceId, String date , String time){
        User user = getUser(userId);
        Source source = getLibrary(libraryId).getSource(sourceId);
        if(user instanceof Student && ((Student)user).canBorrow(libraryId,source,date,time)){
            return true;
        }if(user instanceof Staff && ((Staff)user).canBorrow(libraryId,source,date,time)){
            return true;
        }if(user instanceof Professor && ((Professor)user).canBorrow(libraryId,source,date,time)){
            return true;
        }
        return false;
    }
    public void userBorrow(String userId, String libraryId, String sourceId, String date, String time){
        User user = getUser(userId);
        if(user instanceof Student){
            ((Student) user).borrow(libraryId,sourceId,date,time);
        }else if(user instanceof Staff){
            ((Staff) user).borrow(libraryId,sourceId,date,time);
        }else if(user instanceof Professor){
            ((Professor) user).borrow(libraryId,sourceId,date,time);
        }
        Source source = getLibrary(libraryId).getSource(sourceId);
        if(source instanceof NormalBook){
            ((NormalBook) source). minusRemaining();
        }
        else if(source instanceof Thesis){
            ((Thesis) source).setBorrowed(true);
        }
    }
    public boolean hasUserBorrowedSource(String userId, String libraryId, String sourceId){
        User user = getUser(userId);
        if(user instanceof Student){
            return ((Student) user).hasBorrowedSource(libraryId,sourceId);
        }if(user instanceof Staff){
            return ((Staff) user).hasBorrowedSource(libraryId,sourceId);
        }else if(user instanceof Professor){
            return ((Professor) user).hasBorrowedSource(libraryId,sourceId);
        }
        return false;
    }
    public long userReturns(String userId, String libraryId, String sourceId, String date, String time){
        User user = getUser(userId);
        Source source = getLibrary(libraryId).getSource(sourceId);
        if(source instanceof NormalBook){
            ((NormalBook) source).plusRemaining();
        }
        else{//if(source instanceof Thesis){
            ((Thesis) source).setBorrowed(true);
        }
        if(user instanceof Student){
            return ((Student) user).returns(libraryId,source,date,time);
        }else if(user instanceof Staff){
            return ((Staff) user).returns(libraryId,source,date,time);
        }else if(user instanceof Professor){
            return ((Professor) user).returns(libraryId,source,date,time);
        }
        return 0;
    }
    public int getUserCountOfBorrowedSources(String userId){
        User user = getUser(userId);
        if(user instanceof Student){
            return ((Student) user).getCountOfBorrowedSources();
        }
        else if(user instanceof Staff){
            return ((Staff) user).getCountOfBorrowedSources();
        }
        else if(user instanceof Professor){
            return ((Professor) user).getCountOfBorrowedSources();
        }
        return 0;
    }
    public long getUserDebt(String userId){
        User user = getUser(userId);
        if(user instanceof Student){
            return ((Student) user).getDebt();
        }
        else if(user instanceof Staff){
            return ((Staff) user).getDebt();
        }
        else if(user instanceof Professor){
            return ((Professor) user).getDebt();
        }
        return 0;
    }
    public void userAddAComment(String userId , String libraryId , String sourceId, String comment){
        Source source = getLibrary(libraryId).getSource(sourceId);
        User user = getUser(userId);
        if(user instanceof Professor){
            ((Professor) user).addAComment(source,comment);
        } else if (user instanceof Student){
            ((Student) user).addAComment(source,comment);
        }
    }

    //category
    public void addCategory(String categoryId, String name, String superCategory){
        Category newCategory = new Category(categoryId,name,superCategory);
        categories.add(newCategory);
    }
    public Category getCategory(String categoryId){
        for (Category category:categories) {
            if(category.getCategoryId().equals(categoryId)){
                return category;
            }
        }
        return null;
    }
    public boolean doesCategoryExist(String categoryId){
        if(this.getCategory(categoryId)==null){
            return false;
        }
        return true;
    }

    //library
    public void addLibrary(String libraryId, String name, int yearOfEstablishment, int countOfDesks, String address){
        Library newLibrary = new Library(libraryId,name,yearOfEstablishment,countOfDesks,address);
        libraries.add(newLibrary);
    }
    public Library getLibrary(String libraryId){
        for (Library library:libraries) {
            if(library.getLibraryId().equals(libraryId)){
                return library;
            }
        }
        return null;
    }
    public boolean doesLibraryExist (String libraryId){
        if(this.getLibrary(libraryId)==null){
            return false;
        }
        return true;
    }
    //searches
    public void search(String searchKey){
        HashSet<String> searchResult = new HashSet<String>();
        String searchKeyToLowerCase = searchKey.toLowerCase();
        for (Library library:libraries) {
            for (Source source:library.getSources()) {
                if(source.getTitle().toLowerCase().contains(searchKeyToLowerCase)||source.getAuthor().toLowerCase().contains(searchKeyToLowerCase))
                {
                    searchResult.add(source.getSourceId());
                }
                if(source instanceof Book && ((Book) source).getPublisher().toLowerCase().contains(searchKeyToLowerCase)){
                    searchResult.add(source.getSourceId());
                }
                if(source instanceof Thesis && ((Thesis) source).getSupervisor().toLowerCase().contains(searchKeyToLowerCase)){
                    searchResult.add(source.getSourceId());
                }
            }
        }
        if(searchResult.size()==0){
            System.out.println("not-found");
            return;
        }
        ArrayList<String> sortedSearchResult = new ArrayList<String>();
        for (String element:searchResult) {
            sortedSearchResult.add(element);
        }
        sortedSearchResult.sort(String::compareToIgnoreCase);
        System.out.printf("%s",sortedSearchResult.get(0));
        for (int i = 1; i < sortedSearchResult.size(); i++) {
            System.out.printf("|%s",sortedSearchResult.get(i));
        }
        System.out.println();
    }
    public void searchUser(String searchKey){
        String searchKeyToLowerCase = searchKey.toLowerCase();
        ArrayList<String> searchResult = new ArrayList<String>();
        for (User user: users) {
            if(user.getFirstName().toLowerCase().contains(searchKeyToLowerCase)||user.getLastName().toLowerCase().contains(searchKeyToLowerCase)){
                searchResult.add(user.getUserId());
            }
        }
        if(searchResult.size()==0){
            System.out.println("not-found");
            return;
        }
        searchResult.sort(String::compareToIgnoreCase);
        System.out.printf("%s",searchResult.get(0));
        for (int i = 1; i < searchResult.size(); i++) {
            System.out.printf("|%s",searchResult.get(i));
        }
        System.out.println();
    }



}
