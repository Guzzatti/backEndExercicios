package org.example;

public class Personagem {
    public String nome;
    public int vida;
    public int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }
    public void atacar(Personagem alvo) {
        if (alvo.vida > 0) {
            System.out.println(this.nome + " ataca " + alvo.nome);
            alvo.receberDano(this.ataque);
        } else {
            System.out.println(alvo.nome + " já foi derrotado.");
        }
    }
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(this.nome + " foi derrotado!");
        }
    }
}
