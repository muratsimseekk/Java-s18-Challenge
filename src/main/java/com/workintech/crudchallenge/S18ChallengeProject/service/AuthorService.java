package com.workintech.crudchallenge.S18ChallengeProject.service;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    Author getAuthorByID(Long id);
    Author addAuthor(Author author);
    Author updateAuthor(Author author , Long id);
    Author deleteAuthor(Long id);

}
