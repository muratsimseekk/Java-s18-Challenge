package com.workintech.crudchallenge.S18ChallengeProject.controller;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Author;
import com.workintech.crudchallenge.S18ChallengeProject.entity.Book;
import com.workintech.crudchallenge.S18ChallengeProject.service.AuthorService;
import com.workintech.crudchallenge.S18ChallengeProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workintech")
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    //TODO hata gelirse @AllArgs ekleyip cozmeye calis.
    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/author")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/author/{id}")
    public Author getAuthorByID(@PathVariable Long id){
        return authorService.getAuthorByID(id);
    }

    @PostMapping("/author")
    public Author save(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PostMapping("/author/{bookID}")
    public Author save(@RequestBody Author author ,@PathVariable Long bookID){
        Book foundBook = bookService.getBookByID(bookID);
        author.addBook(foundBook);
        authorService.addAuthor(author);
        return author;
    }

    @PutMapping("/author/{authorID}")
    public Author update(@RequestBody Author author,@PathVariable Long authorID){
        return authorService.updateAuthor(author, authorID);
    }

    @DeleteMapping("/author/{id}")
    public Author delete(Long id){
        return authorService.deleteAuthor(id);
    }
}
