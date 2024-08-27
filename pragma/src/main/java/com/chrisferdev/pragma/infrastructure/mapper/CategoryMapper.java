package com.chrisferdev.pragma.infrastructure.mapper;


import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.infrastructure.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    Category toCategory(CategoryEntity categoryEntity);

    Iterable<Category> toCategoryList(Iterable<CategoryEntity> categoryEntities);

    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(Category category);
}
