package com.chrisferdev.pragma.application.usecase;

import com.chrisferdev.pragma.domain.model.Product;
import com.chrisferdev.pragma.domain.port.IProductPort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final IProductPort iProductPort;

    public ProductService(IProductPort iProductPort) {
        this.iProductPort = iProductPort;
    }

    public Product saveProduct(Product product){
        return iProductPort.saveProduct(product);
    }
}
