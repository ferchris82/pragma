package com.chrisferdev.pragma.infrastructure.adapter;

import com.chrisferdev.pragma.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}
