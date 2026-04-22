package com.cbalcaza.scriptlinker.application.ports.in;

import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;

public interface ScriptUseCases {
    ScriptEntity createScript(ScriptEntity scriptEntity);
    ScriptEntity findScriptById(Long id);
}
