package services;

import entities.Book;
import java.util.Scanner;

public class BookService {

    public Book createBook(){
        Book book = new Book();
        Scanner read = new Scanner(System.in);

        System.out.println("in: [String] Title");
        book.setTitle(read.nextLine());

        System.out.println("in: [String] Author");
        book.setAuthor(read.nextLine());

        System.out.println("in: int] ISBN");
        book.setIsbn(read.nextInt());

        System.out.println("in: [String] number of pages");
        book.setPages(read.nextInt());

        return book;
    }

    public void showBook(Book book){
        System.out.println(book.toString());
    }
}
