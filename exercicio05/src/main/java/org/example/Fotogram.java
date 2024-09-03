package org.example;

public class Fotogram implements PlataformaSocial {

    @Override
    public void compartilharPostagem(Postagem postagem) {
        if (!postagem.getTipo().equals("imagem") && !postagem.getTipo().equals("video")) {
            throw new UnsupportedOperationException("O Fotogram suporta apenas o compartilhamento de imagens e vídeos.");
        }
        System.out.println("Você compartilhou essa " + postagem.getTipo() + " no Fotogram: " + postagem.getTitulo());
    }
}
