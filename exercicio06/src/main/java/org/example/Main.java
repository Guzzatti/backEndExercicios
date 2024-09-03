package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Toy Story 5", 15.0, 0));
        cinema.adicionarFilme(new Filme("Homem Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Vingadores", 25.0, 14));
        cinema.adicionarFilme(new Filme("Estômago 2", 15.0, 16));
        cinema.adicionarFilme(new Filme("Deadpool e Wolverine", 18.0, 18));


        while (true) {
            System.out.print("Qual o seu nome? ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Qual a sua idade? ");
            int idadeCliente = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = new Cliente(nomeCliente, idadeCliente);

            System.out.print("Que filme você deseja assistir? ");
            String nomeFilme = scanner.nextLine();

            Filme filmeEscolhido = cinema.buscarFilme(nomeFilme);
            if (filmeEscolhido == null) {
                System.out.println("O filme " + nomeFilme + " não está disponível.");
                continue;
            }

            if (cliente.getIdade() < filmeEscolhido.getIdadeMinima()) {
                System.out.println("O ingresso não pode ser vendido pois sua idade não permite!");
                continue;
            }

            System.out.print("Qual assento você deseja? ");
            String assentoEscolhido = scanner.nextLine();

            if (!cinema.assentoDisponivel(assentoEscolhido)) {
                System.out.println("O ingresso não pode ser vendido pois o assento " + assentoEscolhido + " não está mais disponível!");
                continue;
            }

            Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assentoEscolhido);
            cinema.venderIngresso(ingresso);

            System.out.print("Deseja realizar outra venda? (sim/não) ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("não")) {
                break;
            }
        }

        scanner.close();
    }
}
