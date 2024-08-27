package com.chrisferdev.pragma.domain.port;

import com.chrisferdev.pragma.domain.model.Category;

// Contrato entre el modelo

public interface ICategoryPort {
    Category saveCategory (Category category);
    boolean existsByName(String name);
}
