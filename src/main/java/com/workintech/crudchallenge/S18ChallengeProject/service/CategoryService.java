package com.workintech.crudchallenge.S18ChallengeProject.service;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryByID(Long id);
    Category save(Category category);

    Category updateCategory(Category category , Long id);
    Category deleteCategory(Long id);
}
