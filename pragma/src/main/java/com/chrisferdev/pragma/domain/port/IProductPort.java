package com.chrisferdev.pragma.domain.port;

import com.chrisferdev.pragma.domain.model.Product;

public interface IProductPort {

    Product saveProduct(Product product);
}
