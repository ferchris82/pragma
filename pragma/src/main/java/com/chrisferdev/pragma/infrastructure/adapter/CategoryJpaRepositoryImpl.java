package com.chrisferdev.pragma.infrastructure.adapter;


import com.chrisferdev.pragma.domain.model.Category;
import com.chrisferdev.pragma.domain.port.ICategoryPort;
import com.chrisferdev.pragma.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryJpaRepositoryImpl implements ICategoryPort {
    private final ICategoryJpaRepository iCategoryJpaRepository;
    private final CategoryMapper categoryMapper;

    public CategoryJpaRepositoryImpl(ICategoryJpaRepository iCategoryJpaRepository, CategoryMapper categoryMapper) {
        this.iCategoryJpaRepository = iCategoryJpaRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category saveCategory(Category category){
        if(existsByName(category.getName())){
            throw new IllegalArgumentException();
        }
        return categoryMapper.toCategory(iCategoryJpaRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public boolean existsByName(String name) {
        return iCategoryJpaRepository.existsByName(name);
    }
}
