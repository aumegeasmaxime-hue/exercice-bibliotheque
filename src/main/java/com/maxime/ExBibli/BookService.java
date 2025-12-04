package com.maxime.ExBibli;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBook() {
        return repository.findAll();
    }
    public Book getBookById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("This Book id " + id + " not found"));
    }
    public void createANewBook(Book book) {
        repository.save(book);
    }


    public void borrowBook(Integer id, Map<Boolean, Object> borrow) {

    }
}
