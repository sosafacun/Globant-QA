import services.BookService;
import entities.Book;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();

        Book book1 = bookService.createBook();
        Book book2 = bookService.createBook();
        Book book3 = bookService.createBook();

        bookService.showBook(book1);
        bookService.showBook(book2);
        bookService.showBook(book3);
    }
}