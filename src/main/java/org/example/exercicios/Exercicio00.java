package org.example.exercicios;

import java.util.Scanner;
import java.util.Random;

public class Exercicio00 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        Random random = new Random();
        int numeroAleatorio = random.nextInt(90) + 10;

        String nomeDeUsuario = nome + sobrenome + numeroAleatorio;

        System.out.println("Nome de usuário gerado: " + nomeDeUsuario);

        scanner.close();
    }
}
