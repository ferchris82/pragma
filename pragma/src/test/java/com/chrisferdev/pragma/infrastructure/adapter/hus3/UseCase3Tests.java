package com.chrisferdev.pragma.infrastructure.adapter.hus3;

import com.chrisferdev.pragma.application.usecase.BrandService;
import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.domain.port.IBrandPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class
TestingH3 {
    IBrandPort iBrandPort;
    BrandService brandService;

    @BeforeEach
    void setUp(){
        iBrandPort = mock(IBrandPort.class);
        brandService = new BrandService(iBrandPort);
    }

    @Test
    void saveBrand(){
        // Arrange
        Brand brand = new Brand();
        brand.setName("Marca prueba");
        brand.setDescription("Descripción Marca");

        // Mock behavior Crea el objeto
        when(iBrandPort.saveBrand(any(Brand.class))).thenReturn(brand);

        // Acti
        Brand saveBrand = brandService.saveBrand(brand);

        // Assert
        assertNotNull(saveBrand);
        assertEquals("Marca prueba", saveBrand.getName());
        assertEquals("Descripción Marca", saveBrand.getDescription());

        // Verify
        verify(iBrandPort, times(1)).saveBrand(any(Brand.class));
    }
}
