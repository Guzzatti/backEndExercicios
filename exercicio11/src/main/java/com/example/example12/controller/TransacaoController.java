package com.example.example12.controller;

import com.example.example12.dto.TransacaoRequestDTO;
import com.example.example12.dto.TransacaoResponseDTO;
import com.example.example12.service.TransacoesService;
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
