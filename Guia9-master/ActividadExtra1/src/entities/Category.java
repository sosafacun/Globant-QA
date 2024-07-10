package entities;

public class Category {
    private int categoryID;
    private String Category;

    public Category(int categoryID, String category) {
        this.categoryID = categoryID;
        Category = category;
    }
    public Category() {
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
