package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título da postagem: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descrição da postagem: ");
        String descricao = scanner.nextLine();

        System.out.print("Escolha o tipo da postagem (1 para texto, 2 para imagem, 3 para vídeo): ");
        int tipoEscolhido = scanner.nextInt();
        scanner.nextLine();

        String tipo = "";
        switch (tipoEscolhido) {
            case 1:
                tipo = "texto";
                break;
            case 2:
                tipo = "imagem";
                break;
            case 3:
                tipo = "video";
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        Postagem postagem = new Postagem(titulo, descricao, tipo);

        MyBook myBook = new MyBook();
        myBook.compartilharPostagem(postagem);

        if (tipo.equals("imagem") || tipo.equals("video")) {
            Fotogram fotogram = new Fotogram();
            try {
                fotogram.compartilharPostagem(postagem);
            } catch (UnsupportedOperationException e) {
                System.out.println("Ocorreu um erro ao compartilhar essa postagem no Fotogram: " + e.getMessage());
            }
        }

        if (tipo.equals("video")) {
            AnyTube anyTube = new AnyTube();
            try {
                anyTube.compartilharPostagem(postagem);
            } catch (UnsupportedOperationException e) {
                System.out.println("Ocorreu um erro ao compartilhar essa postagem no AnyTube: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
