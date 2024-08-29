package com.chrisferdev.pragma.infrastructure.adapter.hus5;

import com.chrisferdev.pragma.application.usecase.ProductService;
import com.chrisferdev.pragma.domain.model.Product;
import com.chrisferdev.pragma.domain.port.IProductPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class UseCase5Tests {

     IProductPort iProductPort;
     ProductService productService;

     @BeforeEach
     void setUp() {
         iProductPort = mock(IProductPort.class);
         productService = new ProductService(iProductPort);
     }

    @Test
    void saveProduct(){
        // Arrange
        Product product = new Product();
        product.setName("Producto de prueba");
        product.setDescription("Descripción del producto");
        product.setQuantity(10);
        product.setPrice(BigDecimal.valueOf(99.99));
        product.setCategoryIds(List.of(1L, 2L)); // Valid categories
        product.setBrandIds(List.of(1L)); // Valid brand

        // Mock behavior Crea el objeto
        when(iProductPort.saveProduct(any(Product.class))).thenReturn(product);

        // Acti
        Product saveProduct = productService.saveProduct(product);

        // Assert
        assertNotNull(saveProduct);
        assertEquals("Producto de prueba", saveProduct.getName());
        assertEquals("Descripción del producto", saveProduct.getDescription());
        assertEquals(10, saveProduct.getQuantity());
        assertEquals(BigDecimal.valueOf(99.99), saveProduct.getPrice());


        // Verify
        verify(iProductPort, times(1)).saveProduct(any(Product.class));
    }
}
