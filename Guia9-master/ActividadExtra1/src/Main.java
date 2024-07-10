import entities.Category;
import entities.Product;
import services.CategoryService;
import services.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static CategoryService categoryService = new CategoryService();
    public static ProductService productService = new ProductService();
    public static ArrayList<Category> categories = categoryService.loadCategories();
    public static ArrayList<Product> products = productService.loadProducts(categories);
    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("1 - Buy");
            System.out.println("2 - Check inventory");
            System.out.println("3 - Add new products");
            System.out.println("4 - Add inventory");
            System.out.println("5 - Add categories");
            System.out.println("0 - exit");

            String opt = read.nextLine();

            switch (Integer.parseInt(opt)){
                case 1 ->products = productService.buy(products);
                case 2 ->productService.checkInventory(products);
                case 3-> products.addAll(productService.addProducts(products, categories));
                case 4->products = productService.addInventory(products);
                case 5->{}//categoryService.addCategories(categories);

                case 0 ->System.exit(0);
                default -> System.out.println("Wrong option.");
            }
        }

    }
}