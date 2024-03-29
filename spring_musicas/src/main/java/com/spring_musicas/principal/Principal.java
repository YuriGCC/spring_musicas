package com.spring_musicas.principal;

import com.spring_musicas.modelos.Artista;
import com.spring_musicas.modelos.Musica;
import com.spring_musicas.modelos.TipoDeArtista;
import com.spring_musicas.repositorio.ArtistaRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepositorio repositorio;
    public Principal() {}
    public Principal(ArtistaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var menu = """
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar músicas
                4 - Buscar músicas por artista
                5 - Dados sobre um artista
                0 - Sair
                """;
        var opcao = -1;

        while(opcao!=0) {
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    buscarDadosArtista();
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarDadosArtista() {
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Digite o nome do artistas: ");
        var nomeArtista = leitura.nextLine();

        List<Musica> musicasArtista = repositorio.buscarMusicaArtista(nomeArtista);
        musicasArtista.forEach(m -> System.out.println(m.getTitulo()));

    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void cadastrarMusica() {

        System.out.println("Digite o nome do artista da música: ");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);

        if (artista.isPresent()) {
            System.out.println("Digite o nome da música: ");
            var nomeMusica = leitura.nextLine();

            Musica musica = new Musica(nomeMusica);
            artista.get().getMusicas().add(musica);
            musica.setArtista(artista.get());
            repositorio.save(artista.get());

        } else {
            System.out.println("Artista não está em nossos registros.");
        }
    }

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Digite o nome do artista: ");
            var nome = leitura.nextLine();

            System.out.println("Informe o tipo desse artista: (solo, dupla ou banda");
            var tipoArtista = leitura.nextLine();
            TipoDeArtista tipoDeArtista = TipoDeArtista.fromString(tipoArtista.toLowerCase());
            Artista artista = new Artista(nome, tipoDeArtista);
            repositorio.save(artista);

            System.out.println("Cadastrar novo artista? (S/N");
            cadastrarNovo = leitura.nextLine();
        }

    }
}
