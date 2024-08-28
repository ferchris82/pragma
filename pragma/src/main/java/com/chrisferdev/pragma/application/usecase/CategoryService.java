package com.chrisferdev.pragma.application.usecase;

import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.domain.model.PaginatedResult;
import com.chrisferdev.pragma.domain.port.ICategoryPort;
import com.chrisferdev.pragma.infrastructure.exception.CategoryAlreadyExistsException;
import org.springframework.stereotype.Service;

// La lógica del negocio

@Service
public class CategoryService {
    private final ICategoryPort iCategoryPort;

    public CategoryService(ICategoryPort iCategoryPort) {
        this.iCategoryPort = iCategoryPort;
    }

    // Métodos
    public Category saveCategory(Category category){
        if(iCategoryPort.existsByName(category.getName())){
            throw new CategoryAlreadyExistsException("La categoría con el nombre " + category.getName() + " ya existe.");

        }
        return iCategoryPort.saveCategory(category);
    }

    public PaginatedResult<Category> findAllCategories(String sortOrder, int page, int size) {
        return iCategoryPort.findAllCategories(sortOrder, page, size);
    }
}