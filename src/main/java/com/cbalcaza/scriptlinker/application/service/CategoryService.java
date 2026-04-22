package com.cbalcaza.scriptlinker.application.service;

import com.cbalcaza.scriptlinker.application.ports.in.CategoryUseCases;
import com.cbalcaza.scriptlinker.application.ports.out.CategoryRepositoryPort;
import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryUseCases {

    @Autowired
    private CategoryRepositoryPort categoryRepositoryPort;

    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        return categoryRepositoryPort.save(category);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepositoryPort.findAll();
    }
}
