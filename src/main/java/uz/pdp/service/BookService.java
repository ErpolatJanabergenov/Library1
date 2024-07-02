package uz.pdp.service;

import uz.pdp.model.Book;

import java.util.List;

import static uz.pdp.Main.scNum;
import static uz.pdp.Main.scStr;
import static uz.pdp.repository.BookRepository.books;

public class BookService {

    public void addBook() {
        System.out.print("Enter name: ");
        String bookName = scStr.nextLine();

        System.out.print("Enter author: ");
        String author = scStr.nextLine();

        System.out.print("Enter year: ");
        int year = scNum.nextInt();

        System.out.print("Enter isbn: ");
        String isbn = scStr.nextLine();

        Book book1 = new Book(bookName, author, year, isbn);
        books.add(book1);

        System.out.println("Book added!");
    }

    public void findBook() {
        System.out.print("Enter book name: ");
        String name = scStr.nextLine();

        System.out.print("Enter author: ");
        String author = scStr.nextLine();

        System.out.print("Enter year: ");
        int year = scNum.nextInt();
        List<Book> list = books.stream().filter(b -> b.getName().equals(name) && b.getAuthor().equals(author) && b.getYear() == year).toList();
        if (list.isEmpty()) {
            System.out.println("Book not found!");
        }else {
            list.forEach(System.out::println);
        }
    }

    public void removeBook() {
        getAllBooks();
        System.out.print("Enter book index: ");
        int bookIndex = scNum.nextInt();
        if (bookIndex < 0 || bookIndex > books.size()) {
            System.out.println("Book index out of bounds!");
            return;
        }
        books.remove(bookIndex -1);
        System.out.println("Book removed!");
    }

    public void getAllBooks() {
        if (books.isEmpty()){
            System.out.println("No books found");
        }else {
            int i = 0;
            for (Book book : books) {
                System.out.println(++i + ". " +
                        book.getName() +
                        " - " + book.getAuthor() +
                        " - " + book.getYear());
            }
        }
    }
}
