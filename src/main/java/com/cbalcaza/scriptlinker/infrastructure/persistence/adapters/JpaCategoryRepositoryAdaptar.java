package com.cbalcaza.scriptlinker.infrastructure.persistence.adapters;

import com.cbalcaza.scriptlinker.application.ports.out.CategoryRepositoryPort;
import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;
import com.cbalcaza.scriptlinker.infrastructure.persistence.repositories.SpringDataCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaCategoryRepositoryAdaptar implements CategoryRepositoryPort {

    @Autowired
    private SpringDataCategoryRepository springDataCategoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity category) {
       return springDataCategoryRepository.save(category);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return springDataCategoryRepository.findAll();
    }

    @Override
    public CategoryEntity findById(Long id) {
        return springDataCategoryRepository.findById(id).orElse(null);
    }
}
