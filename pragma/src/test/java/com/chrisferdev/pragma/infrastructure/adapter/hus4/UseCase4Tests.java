package com.chrisferdev.pragma.infrastructure.adapter.hus4;

import com.chrisferdev.pragma.application.usecase.BrandService;
import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.domain.model.PaginatedResult;
import com.chrisferdev.pragma.domain.port.IBrandPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class UseCase4Tests {

    IBrandPort iBrandPort;
    BrandService brandService;

    @BeforeEach
    void setUp() {
        iBrandPort = mock(IBrandPort.class);
        brandService = new BrandService(iBrandPort);
    }

    @Test
    void findAllBrands() {
        // Arrange
        Brand brand = new Brand();
        brand.setName("Brand 1");
        List<Brand> brands = List.of(brand);
        PaginatedResult<Brand> paginatedResult = new PaginatedResult<>(
                brands,  // items
                0,           // number (página actual)
                1,           // size (tamaño de la página)
                1            // totalElements (total de elementos en la base de datos)
        );

        // Configura el mock para que devuelva el resultado paginado
        when(iBrandPort.findAllBrands("asc", 0, 1)).thenReturn(paginatedResult);

        // Act
        PaginatedResult<Brand> result = brandService.findAllBrands("asc", 0, 1);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements()); // Verifica el número total de elementos
        assertEquals(1, result.getItems().size()); // Verifica el tamaño de los items en la página
        assertEquals("Brand 1", result.getItems().get(0).getName()); // Verifica el nombre de la marca
        assertEquals(0, result.getNumber()); // Verifica el número de la página actual
        assertEquals(1, result.getSize()); // Verifica el tamaño de la página
        verify(iBrandPort, times(1)).findAllBrands("asc", 0, 1); // Verifica que el método fue llamado una vez
    }
}