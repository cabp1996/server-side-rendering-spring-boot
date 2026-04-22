package com.cbalcaza.scriptlinker.application.service;

import com.cbalcaza.scriptlinker.application.ports.in.ScriptUseCases;
import com.cbalcaza.scriptlinker.application.ports.out.ScriptRepositoryPort;
import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptService implements ScriptUseCases {

    @Autowired
    private ScriptRepositoryPort scriptRepositoryPort;

    @Override
    public ScriptEntity createScript(ScriptEntity scriptEntity) {
        return scriptRepositoryPort.save(scriptEntity);
    }

    @Override
    public ScriptEntity findScriptById(Long id) {
        return scriptRepositoryPort.findById(id);
    }
}
