package com.cbalcaza.scriptlinker.application.ports.out;

import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;

import java.util.List;

public interface CategoryRepositoryPort {
    CategoryEntity save(CategoryEntity category);
    List<CategoryEntity> findAll();
    CategoryEntity findById(Long id);
}
