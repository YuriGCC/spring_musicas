package com.spring_musicas.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "músicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titulo;

    @ManyToOne
    private Artista artista;

    public Musica() {}

    public Musica(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", artista=" + artista;
    }
}
