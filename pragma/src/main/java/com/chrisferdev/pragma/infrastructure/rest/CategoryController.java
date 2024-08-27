package com.chrisferdev.pragma.infrastructure.rest;

import com.chrisferdev.pragma.application.usecase.CategoryService;
import com.chrisferdev.pragma.domain.model.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }
}
