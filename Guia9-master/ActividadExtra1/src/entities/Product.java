package entities;

public class Product {
    private int barCode;
    private String productName;
    private Category productCategory;
    private int inventory;

    public Product() {
    }

    public Product(int barCode, String productName, Category productCategory, int inventory) {
        this.barCode = barCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.inventory = inventory;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
