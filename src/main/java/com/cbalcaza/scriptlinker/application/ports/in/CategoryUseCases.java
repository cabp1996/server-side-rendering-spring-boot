package com.cbalcaza.scriptlinker.application.ports.in;

import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;

import java.util.List;

public interface CategoryUseCases {
    CategoryEntity createCategory(CategoryEntity category);
    List<CategoryEntity> getAllCategories();
}
