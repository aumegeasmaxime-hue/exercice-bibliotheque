package com.maxime.ExBibli;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/book")
public class BookControler {

    private final BookService service;

    public BookControler(BookService softwareEngineerService) {
        this.service = softwareEngineerService;
    }

    @GetMapping
    public List<Book> getAllBook() {
        return service.getAllBook();

    }

    @GetMapping("/{id}")
    public Book getBookById(
            @PathVariable Integer id
    ) {
        return service.getBookById(id);
    }

    @PostMapping
    public void addBook(
            @RequestBody Book book) {
        service.createANewBook(book);
    }

    @PostMapping
    public void borrowBook(
            @PathVariable Integer id,
            @RequestBody Map<Boolean, Object> borrow
    ) {
        service.borrowBook(id, borrow);


    }

}










