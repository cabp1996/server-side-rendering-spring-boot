package com.cbalcaza.scriptlinker.infrastructure.persistence.adapters;

import com.cbalcaza.scriptlinker.application.ports.out.ScriptRepositoryPort;
import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;
import com.cbalcaza.scriptlinker.infrastructure.persistence.repositories.SpringDataScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaScriptRepositoryAdapter implements ScriptRepositoryPort {

    @Autowired
    private SpringDataScriptRepository springDataScriptRepository;

    @Override
    public ScriptEntity save(ScriptEntity scriptEntity) {
        return springDataScriptRepository.save(scriptEntity);
    }

    @Override
    public ScriptEntity findById(Long id) {
        return springDataScriptRepository.findById(id).orElse(null);
    }

    @Override
    public List<ScriptEntity> findAll() {
        return springDataScriptRepository.findAll();
    }
}
