package com.workintech.crudchallenge.S18ChallengeProject.repository;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {
}
