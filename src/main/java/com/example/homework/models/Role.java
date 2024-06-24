package com.example.homework.models;

public enum Role {
    SYSTEMS_ANALYST("Системный аналитик"),
    JAVA_DEV("Разработчик Java"),
    JS_REACT_DEV("Разработчик JS/React"),
    TESTER("Тестировщик"),
    APP_ADMIN("Прикладной администратор");

    private String russianLocale;

    Role(String russianLocale) {
        this.russianLocale = russianLocale;
    }
}
