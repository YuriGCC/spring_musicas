package com.spring_musicas.modelos;

public enum TipoDeArtista {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipo;
    TipoDeArtista(String tipo) {
        this.tipo = tipo;
    }

    public static TipoDeArtista fromString(String text) {
        for (TipoDeArtista tipoArtista : TipoDeArtista.values()) {
            if (tipoArtista.tipo.equalsIgnoreCase(text)) {
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
