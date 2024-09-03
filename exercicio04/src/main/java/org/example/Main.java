package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCloud musicCloud = new MusicCloud();

        // Adicionando músicas disponíveis com entrada do usuário
        while (true) {
            System.out.print("Digite o nome da música para adicionar ao sistema (ou 'sair' para encerrar): ");
            String titulo = scanner.nextLine();

            if (titulo.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o nome do artista: ");
            String artista = scanner.nextLine();

            musicCloud.adicionarMusica(new Musica(titulo, artista));
        }

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nomePlaylist);

        while (true) {
            System.out.print("Digite o nome da música para a playlist (ou 'sair' para encerrar): ");
            String nomeMusica = scanner.nextLine();

            if (nomeMusica.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o nome do artista: ");
            String nomeArtista = scanner.nextLine();

            try {
                Musica musica = musicCloud.buscarMusica(nomeMusica, nomeArtista);
                playlist.adicionarMusica(musica);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        playlist.imprimirPlaylist();
        scanner.close();
    }
}
