package com.maxime.ExBibli;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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
    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("This Book id " + id + " not found"));
    }
    public void createANewBook(Book book) {
        repository.save(book);
    }



    public void borrowBook(Long id) {
        Book borrow = getBookById(id);
        borrow.setAvailable(false);
        repository.save(borrow);
    }
    public void returnBook(Long id) {
        Book returnBook = getBookById(id);
        returnBook.setAvailable(true);
        repository.save(returnBook);
    }


    public void researchBookByAuthor(String author) {
        repository.

    }
}
