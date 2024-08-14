package org.example.exercicios;

import java.util.Scanner;

public class Exercicio01 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que ambientação você prefere?");
        System.out.println("1. Sci-fi");
        System.out.println("2. Medieval");
        int ambientacao = scanner.nextInt();

        if (ambientacao != 1 && ambientacao != 2) {
            System.out.println("Escolha inválida. O programa será encerrado.");
            return;
        }

        System.out.println("Que gênero você prefere?");
        System.out.println("1. Comédia");
        System.out.println("2. Drama");
        int genero = scanner.nextInt();

        if (genero != 1 && genero != 2) {
            System.out.println("Escolha inválida. O programa será encerrado.");
            return;
        }

        if (ambientacao == 1 && genero == 1) {
            System.out.println("Recomendação: Homens de Preto");
        } else if (ambientacao == 1 && genero == 2) {
            System.out.println("Recomendação: Arrival");
        } else if (ambientacao == 2 && genero == 1) {
            System.out.println("Recomendação: Shrek");
        } else if (ambientacao == 2 && genero == 2) {
            System.out.println("Recomendação: Gladiador");
        }

        scanner.close();
    }
}
