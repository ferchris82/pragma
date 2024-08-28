package com.chrisferdev.pragma.domain.port;

import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.domain.model.PaginatedResult;

// Contrato entre el modelo

public interface ICategoryPort {
    Category saveCategory (Category category);
    boolean existsByName(String name);
    PaginatedResult<Category> findAllCategories(String sortOrder, int page, int size);
}
