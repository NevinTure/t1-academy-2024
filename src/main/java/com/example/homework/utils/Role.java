package com.example.homework.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    @JsonProperty("Системный аналитик") SYSTEMS_ANALYST,
    @JsonProperty("Разработчик Java") JAVA_DEV,
    @JsonProperty("Разработчик JS/React") JS_REACT_DEV,
    @JsonProperty("Тестировщик") TESTER,
    @JsonProperty("Прикладной администратор") APP_ADMIN
}
