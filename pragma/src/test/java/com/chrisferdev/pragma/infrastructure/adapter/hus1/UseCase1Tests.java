package com.chrisferdev.pragma.infrastructure.adapter.hus1;

import com.chrisferdev.pragma.application.usecase.CategoryService;
import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.domain.port.ICategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class UseCase1Tests {
    ICategoryPort iCategoryPort;
    CategoryService categoryService;

    @BeforeEach
    void setUp(){
        iCategoryPort = mock(ICategoryPort.class);
        categoryService = new CategoryService(iCategoryPort);
    }

    @Test
    void saveCategory(){
        // Arrange
        Category category = new Category();
        category.setName("Categoría prueba");
        category.setDescription("Descripción Categoria");

        // Mock behavior Crea el objeto
        when(iCategoryPort.saveCategory(any(Category.class))).thenReturn(category);

        // Acti
        Category saveCategory = categoryService.saveCategory(category);

        // Assert
        assertNotNull(saveCategory);
        assertEquals("Categoría prueba", saveCategory.getName());
        assertEquals("Descripción Categoria", saveCategory.getDescription());

        // Verify
        verify(iCategoryPort, times(1)).saveCategory(any(Category.class));
    }
}