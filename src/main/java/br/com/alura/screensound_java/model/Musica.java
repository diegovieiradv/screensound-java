package br.com.alura.screensound_java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Artista artista;

    // Construtor padrão obrigatório para o Hibernate
    public Musica() {}

    // Construtor útil para criar música com título
    public Musica(String titulo) {
        this.titulo = titulo;
    }

    // Construtor útil para criar música com título e artista
    public Musica(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
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
        return "Musica='" + titulo + '\'' +
                ", artista=" + (artista != null ? artista.getNome() : "null");
    }
}
