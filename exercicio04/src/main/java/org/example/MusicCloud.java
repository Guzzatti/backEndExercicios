package org.example;

import java.util.ArrayList;
import java.util.List;

public class MusicCloud {
    private List<Musica> musicasDisponiveis;

    public MusicCloud() {
        this.musicasDisponiveis = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicasDisponiveis.add(musica);
    }

    public Musica buscarMusica(String titulo, String artista) throws Exception {
        for (Musica musica : musicasDisponiveis) {
            if (musica.getTitulo().equalsIgnoreCase(titulo) && musica.getArtista().equalsIgnoreCase(artista)) {
                return musica;
            }
        }
        throw new Exception("A música " + titulo + " - " + artista + " não foi encontrada no sistema.");
    }
}
