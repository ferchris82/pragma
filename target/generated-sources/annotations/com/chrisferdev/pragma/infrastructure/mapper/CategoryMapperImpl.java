package com.chrisferdev.pragma.infrastructure.mapper;

import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.infrastructure.entity.CategoryEntity;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-27T13:55:03-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryEntity.getId() );
        category.setName( categoryEntity.getName() );
        category.setDescription( categoryEntity.getDescription() );

        return category;
    }

    @Override
    public Iterable<Category> toCategoryList(Iterable<CategoryEntity> categoryEntities) {
        if ( categoryEntities == null ) {
            return null;
        }

        ArrayList<Category> iterable = new ArrayList<Category>();
        for ( CategoryEntity categoryEntity : categoryEntities ) {
            iterable.add( toCategory( categoryEntity ) );
        }

        return iterable;
    }

    @Override
    public CategoryEntity toCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( category.getId() );
        categoryEntity.setName( category.getName() );
        categoryEntity.setDescription( category.getDescription() );

        return categoryEntity;
    }
}
