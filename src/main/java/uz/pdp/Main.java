package uz.pdp;

import uz.pdp.model.Book;
import uz.pdp.service.BookService;

import java.util.Scanner;

import static uz.pdp.repository.BookRepository.books;

public class Main {

    public static Scanner scStr = new Scanner(System.in);
    public static Scanner scNum = new Scanner(System.in);
    static BookService bookService = new BookService();




    public static void main(String[] args) {
        {
            Book book1 = new Book("Book1","1",1,"1");
            books.add(book1);
            Book book2 = new Book("Book2","2",2,"2");
            books.add(book2);
            Book book3 = new Book("Book3","3",3,"3");
            books.add(book3);
            Book book4 = new Book("Book4","4",4,"4");
            books.add(book4);
        }


        int num = 0;
        while (true) {
            System.out.println("1. Add Book 2. Read Book 3. Remove Book 4.All Book 0. Exit");
            num = scNum.nextInt();
            switch (num) {
                case 1 -> bookService.addBook();
                case 2 -> bookService.findBook();
                case 3 -> bookService.removeBook();
                case 4 -> bookService.getAllBooks();
                default -> System.out.println("Wrong input");
                case 0 -> {
                    return;
                }
            }
        }



    }


}