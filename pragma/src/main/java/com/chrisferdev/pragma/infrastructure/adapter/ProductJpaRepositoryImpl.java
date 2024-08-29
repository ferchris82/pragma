package com.chrisferdev.pragma.infrastructure.adapter;

import com.chrisferdev.pragma.domain.model.Product;
import com.chrisferdev.pragma.domain.port.IProductPort;
import com.chrisferdev.pragma.infrastructure.exception.ProductException;
import com.chrisferdev.pragma.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductJpaRepositoryImpl implements IProductPort {
    private final IProductJpaRepository iProductJpaRepository;
    private final ProductMapper productMapper;

    public ProductJpaRepositoryImpl(IProductJpaRepository iProductJpaRepository, ProductMapper productMapper) {
        this.iProductJpaRepository = iProductJpaRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product saveProduct(Product product) {
        List<Long> categoryIds = product.getCategoryIds();
        if (categoryIds.isEmpty()) {
            throw new ProductException(ProductException.ErrorType.NO_CATEGORY, "El producto debe tener al menos una categoría asociada.");
        }

        if (categoryIds.size() > 3) {
            throw new ProductException(ProductException.ErrorType.TOO_MANY_CATEGORIES, "El producto no puede tener más de 3 categorías asociadas.");
        }

        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (Long categoryId : categoryIds) {
            if (frequencyMap.containsKey(categoryId)) {
                throw new ProductException(ProductException.ErrorType.DUPLICATE_CATEGORIES, "El producto no puede tener categorías duplicadas.");
            }
            frequencyMap.put(categoryId, 1);
        }

        return productMapper.toProduct(iProductJpaRepository.save(productMapper.toProductEntity(product)));
    }
}
