package services;

import entities.Category;

import java.util.ArrayList;

public class CategoryService {
    public ArrayList<Category> loadCategories (){
        ArrayList<Category> categoryList = new ArrayList<>();

        Category c1 = new Category(categoryList.size(), "Deli");
        categoryList.add(c1);
        Category c2 = new Category(categoryList.size(), "Produce");
        categoryList.add(c2);
        Category c3 = new Category(categoryList.size(), "Clothing");
        categoryList.add(c3);
        Category c4 = new Category(categoryList.size(), "Pet Food");
        categoryList.add(c4);
        Category c5 = new Category(categoryList.size(), "General Goods");
        categoryList.add(c5);
        Category c6 = new Category(categoryList.size(), "Tools");
        categoryList.add(c6);

        return categoryList;
    }

}
