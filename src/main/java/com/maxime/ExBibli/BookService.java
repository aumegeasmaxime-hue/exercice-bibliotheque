package com.maxime.ExBibli;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

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
    public void updateBook(Integer id, Map<String, Object> update) {
        Book bookToUpdate = getBookById(id);
        update.forEach((key , value)->{
            Field filed = ReflectionUtils.findField(Book.class , key);
            if (filed != null){
                filed.setAccessible(true);
                ReflectionUtils.setField(filed,bookToUpdate,value);
            }
        });
        repository.save(bookToUpdate);
    }














}
