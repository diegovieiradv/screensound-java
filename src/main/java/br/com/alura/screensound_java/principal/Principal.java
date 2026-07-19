package br.com.alura.screensound_java.principal;

import br.com.alura.screensound_java.model.Artista;
import br.com.alura.screensound_java.model.Musica;
import br.com.alura.screensound_java.model.TipoArtista;
import br.com.alura.screensound_java.repository.ArtistaRepository;
import br.com.alura.screensound_java.service.ServiceApi;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 9) {
            var menu = """
                    ***** Screen Sound Artistas e Músicas *****
                    
                        1 - Cadastrar artistas
                        2 - Cadastrar músicas
                        3 - Listar músicas
                        4 - Buscar músicas por artista
                        5 - Pesquisar sobre um artista
                    
                        9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }
    }

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")){

        System.out.println("Informe o nome do artista");
        var nome = leitura.nextLine();
        System.out.println("Informe o tipo do artista: (solo, dupla, banda)");
        var tipo = leitura.nextLine();
        TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
        Artista artista = new Artista(nome, tipoArtista);
        repositorio.save(artista);
        System.out.println("Cadastrar novo artista? (S/N)");
        cadastrarNovo = leitura.nextLine();
        }

    }
    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de qual artista?");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()){
            System.out.println("Informe o título da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }
    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }
    private void buscarMusicasPorArtista() {
        System.out.println("Buscar músicas de qual artista?");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscaMusicasPorArtista(nome);
        musicas.forEach(System.out::println);

    }
    private void pesquisarDadosDoArtista() {
        System.out.println("Pesquisar dados sobre qual artista?");
        var nome = leitura.nextLine();
    }

}