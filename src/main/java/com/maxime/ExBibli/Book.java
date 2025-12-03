package com.maxime.ExBibli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autogeneration de value
    private Integer id;
    private String titre;
    private String autor;
    private String isbn;
    private boolean availible;

    public Book() {
    }

    public Book(Integer id, String titre, String autor, String isbn, boolean availible) {
        this.id = id;
        this.titre = titre;
        this.autor = autor;
        this.isbn = isbn;
        this.availible = availible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailible() {
        return availible;
    }

    public void setAvailible(boolean availible) {
        this.availible = availible;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return availible == book.availible && Objects.equals(id, book.id) &&
                Objects.equals(titre, book.titre) && Objects.equals(autor, book.autor) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, autor, isbn, availible);
    }
}





