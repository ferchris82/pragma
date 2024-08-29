package com.chrisferdev.pragma.infrastructure.adapter;

import com.chrisferdev.pragma.infrastructure.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandJpaRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByName(String name);
}
