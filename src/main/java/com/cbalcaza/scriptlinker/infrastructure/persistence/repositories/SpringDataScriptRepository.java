package com.cbalcaza.scriptlinker.infrastructure.persistence.repositories;

import com.cbalcaza.scriptlinker.domain.model.ScriptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataScriptRepository extends JpaRepository<ScriptEntity, Long> {
}
