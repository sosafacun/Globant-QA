package services;

import entities.Category;
import entities.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
//
//    private int barCode;
//    private String productName;
//    private Category productCategory;
Scanner read = new Scanner(System.in);
    String input;
    int code;
    public ArrayList<Product> loadProducts(ArrayList<Category> categories){
        ArrayList<Product> productList = new ArrayList<>();

        Product p1 = new Product(productList.size(), "Ham", categories.get(0), 2);
        productList.add(p1);

        Product p2 = new Product(productList.size(), "Cheese", categories.get(0), 4);
        productList.add(p2);

        Product p3 = new Product(productList.size(), "Hammer", categories.get(2), 20);
        productList.add(p3);

        Product p4 = new Product(productList.size(), "Royal Canning", categories.get(5), 5);
        productList.add(p4);

        Product p5 = new Product(productList.size(), "Cat Chow", categories.get(4), 1);
        productList.add(p5);

        Product p6 = new Product(productList.size(), "Shirt", categories.get(5), 3);
        productList.add(p6);

        Product p7 = new Product(productList.size(), "Screwdriver", categories.get(1), 0);
        productList.add(p7);

        Product p8 = new Product(productList.size(), "Colita", categories.get(0), 1);
        productList.add(p8);

        Product p9 = new Product(productList.size(), "Rosbif", categories.get(0), 2);
        productList.add(p9);

        Product p10 = new Product(productList.size(), "Salami", categories.get(2), 3);
        productList.add(p10);

        return productList;
    }

    public ArrayList<Product> buy(ArrayList<Product> products){
        checkInventory(products);

        System.out.println("Enter the product's code that you want to purchase, press Q at any time to close the receipt.");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        while (true){
            input = read.nextLine();
            if(isQ(input)){break;}
            code = Integer.parseInt(input);
            products.get(code).setInventory(products.get(code).getInventory() - 1);
        }

        return products;
    }
    public void checkInventory(ArrayList<Product> products){

        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=CLIENTS=*=*=*=*=*=*=*=*=");

        for (Product product : products) {
            if (product.getInventory() > 0) {
                System.out.println("Product Code-|-----------Product Name------|--Category--|--Inventory--");
                System.out.println("\t" + product.getBarCode() + "\t\t |\t" + product.getProductName() + "\t\t\t\t|\t\t" + product.getProductCategory().getCategory() + "\t\t|\t\t"+ product.getInventory());
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            }
        }
    }

    public ArrayList<Product> addProducts (ArrayList<Product> products, ArrayList<Category> categories){
        ArrayList<Product> newProducts = new ArrayList<>();
        code = products.size();

        while(true){
            Product product = new Product();
            System.out.println("in: Product Name [String] => ");
            input = read.nextLine();
            if(isQ(input)){break;}
            product.setProductName(input);


            System.out.println("in: Category code [String - parsed Int] =>");
            input = read.nextLine();
            if(isQ(input)){break;}
            product.setProductCategory(categories.get(Integer.parseInt(input)));

            System.out.println("in: Inventory [String - Parsed Int] =>");
            input = read.nextLine();
            if(isQ(input)){break;}
            product.setInventory(Integer.parseInt(input));

            product.setBarCode(code);
            code ++;
            newProducts.add(product);
        }

        return newProducts;
    }

    public ArrayList<Product> addInventory(ArrayList<Product> products){

        while (true){
            System.out.println("in: item Code [String parsed Int]");
            System.out.println("Press Q to cancel.");
            input = read.nextLine();
            if(isQ(input)){break;}

            code = Integer.parseInt(input);

            System.out.println("Enter how many items you wish to add");
            input = read.nextLine();
            if(isQ(input)){break;}
            products.get(code).setInventory(products.get(code).getInventory() + Integer.parseInt(input));

        }

        return products;
    }

    private boolean isQ(String input){

        if (input.equalsIgnoreCase("Q")){
            return true;
        }
        return false;

    }

}
