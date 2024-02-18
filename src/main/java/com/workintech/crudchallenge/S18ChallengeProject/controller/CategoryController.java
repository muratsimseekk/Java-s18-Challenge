package com.workintech.crudchallenge.S18ChallengeProject.controller;

import com.workintech.crudchallenge.S18ChallengeProject.entity.Category;
import com.workintech.crudchallenge.S18ChallengeProject.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryByID(@PathVariable Long id){
        return categoryService.getCategoryByID(id);
    }

    @PostMapping("/category")
    public Category addCategory(Category category){
        return categoryService.save(category);
    }

    @PutMapping("/category/{id}")
    public Category update(@RequestBody Category category ,@PathVariable Long id){
        return categoryService.updateCategory(category,id);
    }

    @DeleteMapping("/category/{id}")
    public Category delete(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
