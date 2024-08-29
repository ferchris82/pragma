package com.chrisferdev.pragma.infrastructure.adapter.hus2;

import com.chrisferdev.pragma.application.usecase.CategoryService;
import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.domain.model.PaginatedResult;
import com.chrisferdev.pragma.domain.port.ICategoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
 class TestingH2 {

    ICategoryPort iCategoryPort;
    CategoryService categoryService;

    @BeforeEach
    void setUp() {
        iCategoryPort = mock(ICategoryPort.class);
        categoryService = new CategoryService(iCategoryPort);
    }

    @Test
    void findAllCategories() {
        // Arrange
        Category category = new Category();
        category.setName("Category 1");
        List<Category> categories = List.of(category);
        PaginatedResult<Category> paginatedResult = new PaginatedResult<>(
                categories,  // items
                0,           // number (página actual)
                1,           // size (tamaño de la página)
                1            // totalElements (total de elementos en la base de datos)
        );

        // Configura el mock para que devuelva el resultado paginado
        when(iCategoryPort.findAllCategories("asc", 0, 1)).thenReturn(paginatedResult);

        // Act
        PaginatedResult<Category> result = categoryService.findAllCategories("asc", 0, 1);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements()); // Verifica el número total de elementos
        assertEquals(1, result.getItems().size()); // Verifica el tamaño de los items en la página
        assertEquals("Category 1", result.getItems().get(0).getName()); // Verifica el nombre de la categoría
        assertEquals(0, result.getNumber()); // Verifica el número de la página actual
        assertEquals(1, result.getSize()); // Verifica el tamaño de la página
        verify(iCategoryPort, times(1)).findAllCategories("asc", 0, 1); // Verifica que el método fue llamado una vez
    }
}