package com.educational.alura.OraculoDoSaber.model;

public enum Linguagem {
    PORTUGUES("pt"),
    INGLES("en"),
    FRANCES("fr"),
    ITALIANO("it"),
    ALEMAO("gr");

    private String idiomasGutendex;

    Linguagem(String idiomasGutendex){
        this.idiomasGutendex = idiomasGutendex;
    }

    public static Linguagem fromString(String text) {
        for (Linguagem idioma : Linguagem.values()) {
            if (idioma.idiomasGutendex.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum Idioma encontrado para a string fornecida: " + text);
    }

}
