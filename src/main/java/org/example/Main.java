package org.example;


import org.example.exercicios.Exercicio00;
import org.example.exercicios.Exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do exercício que você quer executar:");
        String exercicio = scanner.nextLine();
        switch (exercicio) {
            case("1"):
                Exercicio00.main();
                break;
            case("2"):
                Exercicio01.main();
        }

    }
}