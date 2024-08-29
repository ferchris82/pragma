package com.chrisferdev.pragma.infrastructure.mapper;

import com.chrisferdev.pragma.domain.model.Brand;
import com.chrisferdev.pragma.infrastructure.entity.BrandEntity;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T22:21:31-0500",
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
    public Iterable<Brand> toBrandList(Iterable<BrandEntity> brandEntities) {
        if ( brandEntities == null ) {
            return null;
        }

        ArrayList<Brand> iterable = new ArrayList<Brand>();
        for ( BrandEntity brandEntity : brandEntities ) {
            iterable.add( toBrand( brandEntity ) );
        }

        return iterable;
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
