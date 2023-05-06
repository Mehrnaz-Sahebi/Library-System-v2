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
    public User getUser(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }
    public Category getCategory(String categoryId){
        for (Category category:categories) {
            if(category.getCategoryId().equals(categoryId)){
                return category;
            }
        }
        return null;
    }
    public boolean doesLibraryExist (String libraryId){
        for (Library library:libraries) {
            if(library.getLibraryId().equals(libraryId)){
                return true;
            }
        }
        return false;
    }
    public boolean doesUserExist(String userId){
        if(this.getUser(userId)==null){
            return false;
        }
        return true;
    }
    public boolean doesCategoryExist(String categoryId){
        if(this.getCategory(categoryId)==null){
            return false;
        }
        return true;
    }
    public boolean isUserAdmin(String userId){
        for (User user:users) {
            if(user.getUserId().equals(userId)&&user instanceof Admin){
                return true;
            }
        }
        return false;
    }
}
