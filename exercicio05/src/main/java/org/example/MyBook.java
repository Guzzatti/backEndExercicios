package org.example;

public class MyBook implements PlataformaSocial {

    @Override
    public void compartilharPostagem(Postagem postagem) {
        System.out.println("Você compartilhou essa postagem no MyBook: " + postagem.getTitulo());
    }
}
