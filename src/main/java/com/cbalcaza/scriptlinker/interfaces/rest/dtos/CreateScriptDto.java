package com.cbalcaza.scriptlinker.interfaces.rest.dtos;

public record CreateScriptDto(
        String name,
        String path,
        Long categoryId
) {
}
