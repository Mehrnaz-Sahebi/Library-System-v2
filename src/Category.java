
public class Category {
    private String categoryId;
    private String name;
    private String superCategory;
    public Category(String categoryId, String name, String superCategory){
        this.categoryId = categoryId;
        this.name = name;
        this.superCategory = superCategory;
    }

    public String getCategoryId() {
        return categoryId;
    }


}
