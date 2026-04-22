package com.cbalcaza.scriptlinker.interfaces.rest.controllers;

import com.cbalcaza.scriptlinker.application.ports.in.CategoryUseCases;
import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;
import com.cbalcaza.scriptlinker.infrastructure.mappers.CategoryMapper;
import com.cbalcaza.scriptlinker.interfaces.rest.dtos.CreateCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    private CategoryUseCases categoryUseCases;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/create")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        CategoryEntity category= categoryUseCases.createCategory(
            categoryMapper.toEntity(createCategoryDto)
        );
        return ResponseEntity.ok(category);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        List<CategoryEntity> categories = categoryUseCases.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
