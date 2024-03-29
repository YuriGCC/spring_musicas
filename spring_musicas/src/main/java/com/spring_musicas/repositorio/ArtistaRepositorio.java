package com.spring_musicas.repositorio;

import com.spring_musicas.modelos.Artista;
import com.spring_musicas.modelos.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepositorio extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nomeArtista%")
    List<Musica> buscarMusicaArtista(String nomeArtista);
}
