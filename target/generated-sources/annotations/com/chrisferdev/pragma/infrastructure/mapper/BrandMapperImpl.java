package com.chrisferdev.pragma.infrastructure.mapper;

import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.infrastructure.entity.BrandEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T16:30:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toBrand(BrandEntity brandEntity) {
        if ( brandEntity == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( brandEntity.getId() );
        brand.setName( brandEntity.getName() );
        brand.setDescription( brandEntity.getDescription() );

        return brand;
    }

    @Override
    public BrandEntity toBrandEntity(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setId( brand.getId() );
        brandEntity.setName( brand.getName() );
        brandEntity.setDescription( brand.getDescription() );

        return brandEntity;
    }
}
