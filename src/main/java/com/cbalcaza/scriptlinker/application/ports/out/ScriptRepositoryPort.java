package com.cbalcaza.scriptlinker.application.ports.out;

import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;

import java.util.List;

public interface ScriptRepositoryPort {
    ScriptEntity save(ScriptEntity scriptEntity);
    ScriptEntity findById(Long id);
    List<ScriptEntity> findAll();
}
