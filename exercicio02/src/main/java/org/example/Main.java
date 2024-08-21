package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Orc", 100, 10));
        inimigos.add(new Personagem("Goblin", 50, 5));
        inimigos.add(new Personagem("Lobo", 75, 15));

        Personagem jogador = new Personagem("Steve", 100, 20);
        Random random = new Random();

        while (jogador.vida > 0 && inimigos.stream().anyMatch(inimigo -> inimigo.vida > 0)) {
            Personagem alvo;
            do {
                alvo = inimigos.get(random.nextInt(inimigos.size()));
            } while (alvo.vida <= 0);

            jogador.atacar(alvo);

            for (Personagem inimigo : inimigos) {
                if (inimigo.vida > 0) {
                    inimigo.atacar(jogador);
                }
            }
        }

        if (jogador.vida > 0) {
            System.out.println("Steve venceu!");
        } else {
            System.out.println("Steve foi derrotado!");
        }
    }
}
