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
            @PathVariable Long id
    ) {
        return service.getBookById(id);
    }

    @PostMapping
    public void addBook(
            @RequestBody Book book) {
        service.createANewBook(book);
    }
    @PutMapping("/borrow/{id}")
    public void borrowBook(@PathVariable Long id)
    {
        service.borrowBook(id);
    }
    @PutMapping("/return/{id}")
    public void returnBook(@PathVariable Long id)
    {
        service.returnBook(id);
    }
    @GetMapping("/{author}")
    public void researchBookByAuthor (@PathVariable String author)
    {
        service.researchBookByAuthor(author);
    }













}










