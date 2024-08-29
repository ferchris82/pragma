package com.chrisferdev.pragma.infrastructure.mapper;

import com.chrisferdev.pragma.domain.model.Product;
import com.chrisferdev.pragma.infrastructure.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-29T12:44:32-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setName( productEntity.getName() );
        product.setDescription( productEntity.getDescription() );
        product.setQuantity( productEntity.getQuantity() );
        product.setPrice( productEntity.getPrice() );
        List<Long> list = productEntity.getCategoryIds();
        if ( list != null ) {
            product.setCategoryIds( new ArrayList<Long>( list ) );
        }
        List<Long> list1 = productEntity.getBrandIds();
        if ( list1 != null ) {
            product.setBrandIds( new ArrayList<Long>( list1 ) );
        }

        return product;
    }

    @Override
    public ProductEntity toProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setQuantity( product.getQuantity() );
        productEntity.setPrice( product.getPrice() );
        List<Long> list = product.getCategoryIds();
        if ( list != null ) {
            productEntity.setCategoryIds( new ArrayList<Long>( list ) );
        }
        List<Long> list1 = product.getBrandIds();
        if ( list1 != null ) {
            productEntity.setBrandIds( new ArrayList<Long>( list1 ) );
        }

        return productEntity;
    }
}
