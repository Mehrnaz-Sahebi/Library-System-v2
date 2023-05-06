import java.util.HashSet;
import java.util.Scanner;

public class LibrarySystem {
    private HashSet<Library> libraries;
    private HashSet<User> users;
    private HashSet<Category> categories;

    public LibrarySystem(){
        libraries = new HashSet<Library>();
        users = new HashSet<User>();
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



}
