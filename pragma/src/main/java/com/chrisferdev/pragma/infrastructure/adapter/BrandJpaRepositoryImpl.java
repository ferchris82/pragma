package com.chrisferdev.pragma.infrastructure.adapter;

import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.domain.port.IBrandPort;
import com.chrisferdev.pragma.infrastructure.exception.BrandAlreadyExistsException;
import com.chrisferdev.pragma.infrastructure.exception.exceptionhandler.ExceptionResponse;
import com.chrisferdev.pragma.infrastructure.mapper.BrandMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BrandJpaRepositoryImpl implements IBrandPort {

    private final IBrandJpaRepository iBrandJpaRepository;

    public BrandJpaRepositoryImpl(IBrandJpaRepository iBrandJpaRepository, BrandMapper brandMapper) {
        this.iBrandJpaRepository = iBrandJpaRepository;
        this.brandMapper = brandMapper;
    }

    private final BrandMapper brandMapper;
    @Override
    public Brand saveBrand(Brand brand) {
        if(existsByName(brand.getName())){
            throw new BrandAlreadyExistsException(ExceptionResponse.BRAND_ALREADY_EXISTS.getMessage());
        }
        if(brand.getDescription().trim().isEmpty() || brand.getName().trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionResponse.INVALID_BRAND.getMessage());
        }
        return brandMapper.toBrand(iBrandJpaRepository.save(brandMapper.toBrandEntity(brand)));
    }

    @Override
    public boolean existsByName(String name) {
        return iBrandJpaRepository.existsByName(name);
    }
}
