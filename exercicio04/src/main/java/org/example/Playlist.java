package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        System.out.println("Você adicionou a música " + musica.getTitulo() + " - " + musica.getArtista() + " na playlist.");
    }

    public void imprimirPlaylist() {
        System.out.println("Playlist: " + nome);
        for (Musica musica : musicas) {
            System.out.println("- " + musica);
        }
    }
}
