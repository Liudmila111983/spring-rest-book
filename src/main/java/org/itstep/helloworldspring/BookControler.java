package org.itstep.helloworldspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookControler {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBook();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) throws IOException {
        bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Long id) throws IOException {
        book.setId(id);
        bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) throws IOException {
        bookService.deleteBook(id);
    }

    //Поиск
    @GetMapping("books/search")
    public List<Book> findBook(@RequestParam("title") String title) throws IOException {
        return bookService.findBook(title);
    }

    // Пагинация
    @GetMapping("/books/page")
    public List<Book> pageBook(@RequestParam("limit") Integer limit,
                               @RequestParam("offset") Integer offset) throws IOException {
        return bookService.getBookPage(limit, offset);
    }
}
