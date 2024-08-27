package com.chrisferdev.pragma.infrastructure.adapter;

import com.chrisferdev.pragma.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
}
