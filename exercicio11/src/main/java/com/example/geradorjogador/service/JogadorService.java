package com.exemplo.geradorjogador.service;

import com.exemplo.geradorjogador.dto.JogadorRequestDTO;
import com.exemplo.geradorjogador.dto.JogadorResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    private final List<JogadorResponseDTO> jogadores = new ArrayList<>();
    private final Random random = new Random();

    public JogadorResponseDTO criarJogador(JogadorRequestDTO requestDTO) {
        int habilidade = random.nextInt(101); // Gera um número aleatório de 0 a 100
        String statusMessage = habilidade > 80 ? "Jogador excelente" : "Jogador comum";

        JogadorResponseDTO jogador = new JogadorResponseDTO(requestDTO.nome(), requestDTO.apelido(), habilidade, statusMessage);
        jogadores.add(jogador);

        return jogador;
    }

    public List<JogadorResponseDTO> listarJogadores() {
        return jogadores;
    }
}
