package com.spring_musicas.modelos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoDeArtista tipoDeArtista;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public Artista() {}

    public Artista(String nome, TipoDeArtista tipo) {
        this.nome = nome;
        this.tipoDeArtista = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDeArtista getTipoDeArtista() {
        return tipoDeArtista;
    }

    public void setTipoDeArtista(TipoDeArtista tipoDeArtista) {
        this.tipoDeArtista = tipoDeArtista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return
                "Artista='" + nome + '\'' +
                ", tipo=" + tipoDeArtista +
                ", musicas=" + musicas;
    }
}
