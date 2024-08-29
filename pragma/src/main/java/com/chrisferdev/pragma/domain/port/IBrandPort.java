package com.chrisferdev.pragma.domain.port;

import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.domain.model.PaginatedResult;

public interface IBrandPort {

    Brand saveBrand(Brand brand);
    boolean existsByName(String name);
    PaginatedResult<Brand> findAllBrands(String sortOrder, int page, int size);

}
