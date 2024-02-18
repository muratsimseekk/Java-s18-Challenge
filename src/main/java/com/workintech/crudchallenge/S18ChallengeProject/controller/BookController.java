package com.workintech.crudchallenge.S18ChallengeProject.controller;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Author;
import com.workintech.crudchallenge.S18ChallengeProject.entity.Book;
import com.workintech.crudchallenge.S18ChallengeProject.entity.Category;
import com.workintech.crudchallenge.S18ChallengeProject.service.AuthorService;
import com.workintech.crudchallenge.S18ChallengeProject.service.BookService;
import com.workintech.crudchallenge.S18ChallengeProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;
    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/book")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable Long id){
        return bookService.getBookByID(id);
    }

    @PostMapping("/book/{categoryID}")
    public Book addBook(@RequestBody Book book,@PathVariable Long categoryID){
        Category category = categoryService.getCategoryByID(categoryID);
        book.setCategory(category);
        category.addBook(book);
        bookService.addBookByCgID(book);

        return book;
    }

    @PostMapping("/book/{categoryID}/{authorID}")
    public Book addBook(@RequestBody Book book,@PathVariable Long categoryID ,Long authorID){

        Category category = categoryService.getCategoryByID(categoryID);
        book.setCategory(category);
        category.addBook(book);

        Author author = authorService.getAuthorByID(authorID);
        author.addBook(book);
        book.setAuthor(author);

        bookService.addBookByCgID(book);

        return book;
    }

    @PutMapping("/book/{id}")
    public Book update(@RequestBody Book book ,@PathVariable Long id){
        return bookService.update(book,id);
    }

    @DeleteMapping("/book/{id}")
    public Book delete(@PathVariable Long id){
        return bookService.delete(id);
    }
}
