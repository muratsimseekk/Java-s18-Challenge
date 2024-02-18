package com.workintech.crudchallenge.S18ChallengeProject.repository;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
