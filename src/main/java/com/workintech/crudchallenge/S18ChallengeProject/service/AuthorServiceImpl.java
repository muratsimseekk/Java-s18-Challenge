package com.workintech.crudchallenge.S18ChallengeProject.service;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Author;
import com.workintech.crudchallenge.S18ChallengeProject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByID(Long id) {
        Optional<Author> optional = authorRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        //TODO Eslesen id yoksa Exception firlat.
        return null;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
    @Override
    public Author updateAuthor(Author author, Long id) {
        Optional<Author> optional = authorRepository.findById(id);
        if (optional.isPresent()){
            Author author1 = optional.get();
            author1.setFirstName(author.getFirstName());
            author1.setLastName(author.getLastName());
        }
        //TODO Eslesen bir id yoksa Exception firlat
        return null;
    }

    @Override
    public Author deleteAuthor(Long id) {
        Optional<Author> optional = authorRepository.findById(id);
        if (optional.isPresent()){
            authorRepository.delete(optional.get());
        }
        //TODO Eslesen id yoksa Exception firlat.
        return null;
    }
}
