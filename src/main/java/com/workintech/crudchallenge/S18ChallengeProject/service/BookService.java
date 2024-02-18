package com.workintech.crudchallenge.S18ChallengeProject.service;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookByID(Long id);
    Book addBookByCgID(Book book);

    Book update(Book book , Long id);
    Book delete(Long id);
}
