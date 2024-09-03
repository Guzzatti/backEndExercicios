package org.example;

public class AnyTube implements PlataformaSocial {

    @Override
    public void compartilharPostagem(Postagem postagem) {
        if (!postagem.getTipo().equals("video")) {
            throw new UnsupportedOperationException("O AnyTube suporta apenas o compartilhamento de vídeos.");
        }
        System.out.println("Você compartilhou esse vídeo no AnyTube: " + postagem.getTitulo());
    }
}
