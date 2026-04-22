package com.cbalcaza.scriptlinker.infrastructure.persistence.repositories;

import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
