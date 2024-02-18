package com.workintech.crudchallenge.S18ChallengeProject.service;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Category;
import com.workintech.crudchallenge.S18ChallengeProject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        //TODO eslesen id yoksa Exception firlat
        return null;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            Category existingCategory = optional.get();
            existingCategory.setName(category.getName());
            //TODO booklist category guncellemesi icin islemler buraya gelecek.
        }
        //TODO id eslesmiyorsa Exception firlat.
        return null;
    }

    @Override
    public Category deleteCategory(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            categoryRepository.delete(optional.get());
        }
        //TODO eslesen bir id yoksa Exception firlat
        return null;
    }
}
