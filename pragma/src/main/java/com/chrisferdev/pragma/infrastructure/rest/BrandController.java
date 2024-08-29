package com.chrisferdev.pragma.infrastructure.rest;

import com.chrisferdev.pragma.application.usecase.BrandService;
import com.chrisferdev.pragma.domain.model.Brand;
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
@RequestMapping("api/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @Operation(
            summary = "Guardar una nueva marca",
            description = "Guarda una nueva marca en el sistema. Si ya existe una marca con el mismo nombre, lanza una excepción.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca guardada con éxito",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Brand.class))),
            @ApiResponse(responseCode = "409", description = "Ya existe una marca con ese nombre",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody Brand brand){
        return new ResponseEntity<>(brandService.saveBrand(brand), HttpStatus.CREATED);
    }
}
