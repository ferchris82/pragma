package com.chrisferdev.pragma.infrastructure.mapper;

import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.infrastructure.entity.BrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    Brand toBrand(BrandEntity brandEntity);

    @InheritInverseConfiguration
    BrandEntity toBrandEntity(Brand brand);
}
