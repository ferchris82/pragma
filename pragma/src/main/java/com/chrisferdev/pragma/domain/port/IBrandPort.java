package com.chrisferdev.pragma.domain.port;

import com.chrisferdev.pragma.domain.model.Brand;

public interface IBrandPort {

    Brand saveBrand(Brand brand);
    boolean existsByName(String name);
}
