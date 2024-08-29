package com.chrisferdev.pragma.infrastructure.adapter;

import com.chrisferdev.pragma.infrastructure.entity.BrandEntity;
import com.chrisferdev.pragma.infrastructure.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandJpaRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByName(String name);
    Page<CategoryEntity> findAllByOrderByNameAsc(Pageable pageable);
    Page<CategoryEntity> findAllByOrderByNameDesc(Pageable pageable);
}
