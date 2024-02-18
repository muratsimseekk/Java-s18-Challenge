package com.workintech.crudchallenge.S18ChallengeProject.repository;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
