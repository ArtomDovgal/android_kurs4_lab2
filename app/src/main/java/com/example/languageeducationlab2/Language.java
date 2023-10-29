package com.example.languageeducationlab2;

public enum Language {
    ENGLISH(0),GERMANY(1);

    private Integer id;

    Language(Integer id) {
        this.id = id;
    }

    public static Language fromInt(int id) {
        for (Language language : values()) {
            if (language.id == id) {
                return language;
            }
        }
        throw new IllegalArgumentException("Invalid id: " + id);
    }
}
