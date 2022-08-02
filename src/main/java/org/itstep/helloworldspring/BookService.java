package org.itstep.helloworldspring;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository = new BookRepository("src/main/resources/static/book100.json");

    public List<Book> getBook(){
        return bookRepository.getAllBooks();
    }

    public Book getBookById(int id){
        return bookRepository.getBookById(id);
    }

    public void addBook(Book book) throws IOException {
        bookRepository.addBook((book));
    }

    public void updateBook(Book book) throws IOException {
        bookRepository.updateBook(book);
    }

    public void deleteBook(int id) throws IOException {
        bookRepository.deleteBook(id);
    }

    public List<Book> findBook(String title) throws IOException {
        return bookRepository.findBook(title);
    }
    // limit - сколько выводить
    // offset - смещение относительно начала(Номер первого выводимого объекта)
    public List<Book> getBookPage(int limit, int offset) throws IOException {
        return bookRepository.getBookPage(limit, offset);
    }
}
