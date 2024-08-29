package com.chrisferdev.pragma.infrastructure.rest;

import com.chrisferdev.pragma.application.usecase.ProductService;
import com.chrisferdev.pragma.domain.model.Product;
import com.chrisferdev.pragma.infrastructure.exception.exceptionhandler.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Guardar un nuevo producto",
            description = "Guarda un nuevo producto en el sistema. Si el producto no tiene una categoría asociada o tiene más de 3 , lanza una excepción.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto guardado con éxito",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "El producto no debe tener una categoría duplicada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
    })

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
}
