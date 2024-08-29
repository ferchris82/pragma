package com.chrisferdev.pragma.application.usecase;

import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.domain.model.PaginatedResult;
import com.chrisferdev.pragma.domain.port.IBrandPort;
import com.chrisferdev.pragma.infrastructure.exception.CategoryAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    private final IBrandPort iBrandPort;

    public BrandService(IBrandPort iBrandPort) {
        this.iBrandPort = iBrandPort;
    }


    public Brand saveBrand(Brand brand){
        if(iBrandPort.existsByName(brand.getName())){
            throw new CategoryAlreadyExistsException("La categoría con el nombre " + brand.getName() + " ya existe.");

        }
        return iBrandPort.saveBrand(brand);
    }

    public PaginatedResult<Brand> findAllBrands(String sortOrder, int page, int size) {
        return iBrandPort.findAllBrands(sortOrder, page, size);
    }
}
