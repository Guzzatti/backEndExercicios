package com.example.example11.controller;

import com.example.example11.dto.TransacaoRequestDTO;
import com.example.example11.dto.TransacaoResponseDTO;
import com.example.example11.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO transacaoRequestDTO) {
        return transacoesService.gerarTransacao(transacaoRequestDTO);
    }
}
