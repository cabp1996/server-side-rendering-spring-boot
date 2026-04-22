package com.cbalcaza.scriptlinker.infrastructure.mappers;

import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;
import com.cbalcaza.scriptlinker.infrastructure.persistence.adapters.JpaCategoryRepositoryAdaptar;
import com.cbalcaza.scriptlinker.interfaces.rest.dtos.CreateScriptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptMapper {

    @Autowired
    private JpaCategoryRepositoryAdaptar categoryRepositoryAdaptar;

    public ScriptEntity toEntity(CreateScriptDto createScriptDto) {

        var category = categoryRepositoryAdaptar.findById(createScriptDto.categoryId());

        return ScriptEntity.builder()
                .name(createScriptDto.name())
                .path(createScriptDto.path())
                .category(category)
                .build();
    }
}
