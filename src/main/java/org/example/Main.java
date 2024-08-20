package org.example;

import org.example.exercicios.Exercicio00;
import org.example.exercicios.Exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exercicio;

        while (true) {
            System.out.println("Digite o número do exercício que você quer executar (1 ou 2):");
            exercicio = scanner.nextLine();

            switch (exercicio) {
                case "1":
                    Exercicio00.main();
                    return;
                case "2":
                    Exercicio01.main();
                    return;
                default:
                    System.out.println("Entrada inválida. Por favor, digite 1 ou 2.");
            }
        }
    }
}
