package com.cbalcaza.scriptlinker.infrastructure.mappers;

import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;
import com.cbalcaza.scriptlinker.interfaces.rest.dtos.CreateCategoryDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

   public CategoryEntity toEntity(CreateCategoryDto createCategoryDto) {
        return CategoryEntity.builder()
                .name(createCategoryDto.name())
                .build();
    }
}
