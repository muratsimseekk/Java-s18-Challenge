package com.workintech.crudchallenge.S18ChallengeProject.service;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Book;
import com.workintech.crudchallenge.S18ChallengeProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByID(Long id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isPresent()){
            bookRepository.delete(optional.get());
        }
        //TODO Eger id eslesmezse Exception firlat.
        return null;
    }

    @Override
    public Book addBookByCgID(Book book) {
        return bookRepository.save(book);
    }


    @Override
    public Book update(Book book, Long id) {
        //TODO update tamamla
        return null;
    }

    @Override
    public Book delete(Long id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()){
            bookRepository.delete(optional.get());
        }
        //TODO Id eslesmezse Exception firlat.
        return null;
    }
}
