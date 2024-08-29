package com.chrisferdev.pragma.infrastructure.mapper;

import com.chrisferdev.pragma.domain.model.Product;
import com.chrisferdev.pragma.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "categoryIds", target = "categoryIds")
    @Mapping(source = "brandIds", target = "brandIds")
    Product toProduct(ProductEntity productEntity);


    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);

}
