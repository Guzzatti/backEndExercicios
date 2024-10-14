package com.exemplo.geradorjogador.controller;

import com.exemplo.geradorjogador.dto.JogadorRequestDTO;
import com.exemplo.geradorjogador.dto.JogadorResponseDTO;
import com.exemplo.geradorjogador.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public JogadorResponseDTO criarJogador(@RequestBody JogadorRequestDTO requestDTO) {
        return jogadorService.criarJogador(requestDTO);
    }

    @GetMapping
    public List<JogadorResponseDTO> listarJogadores() {
        return jogadorService.listarJogadores();
    }
}
