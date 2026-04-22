package com.cbalcaza.scriptlinker.interfaces.web;

import com.cbalcaza.scriptlinker.application.ports.in.CategoryUseCases;
import com.cbalcaza.scriptlinker.application.ports.in.ScriptUseCases;
import com.cbalcaza.scriptlinker.domain.model.CategoryEntity;
import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;
import com.cbalcaza.scriptlinker.infrastructure.mappers.CategoryMapper;
import com.cbalcaza.scriptlinker.infrastructure.mappers.ScriptMapper;
import com.cbalcaza.scriptlinker.interfaces.rest.dtos.CreateCategoryDto;
import com.cbalcaza.scriptlinker.interfaces.rest.dtos.CreateScriptDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private CategoryUseCases categoryUseCases;

    @Autowired
    private ScriptUseCases scriptUseCases;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ScriptMapper scriptMapper;

    @GetMapping("/")
    public String home(Model model) {
        List<CategoryEntity> categories= categoryUseCases.getAllCategories();
        model.addAttribute("categories", categories);
        return "index";
    }

    @PostMapping("/api/category/create")
    public String createCategory(@ModelAttribute CreateCategoryDto createCategoryDto) {
        categoryUseCases.createCategory(
                categoryMapper.toEntity(createCategoryDto)
        );
        return "redirect:/";
    }

    @PostMapping("/api/script/create")
    public String createCategory(@ModelAttribute CreateScriptDto createScriptDto) {
        scriptUseCases.createScript(
                scriptMapper.toEntity(createScriptDto)
        );
        return "redirect:/";
    }

    @GetMapping("/api/script/execute/{id}")
    public ResponseEntity<Void> executeScript(@PathVariable String id) {
        var scriptId = Long.parseLong(id);
        ScriptEntity script = scriptUseCases.findScriptById(scriptId);

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", script.getPath());
            pb.start();

            log.info("Script ejecutado exitosamente: {}", script.getPath());
            return ResponseEntity.ok().build();

        } catch (IOException e) {

            log.error("Error al ejecutar el script: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}

