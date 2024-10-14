package com.example.example12.service;

import com.example.example12.dto.TransacaoRequestDTO;
import com.example.example12.dto.TransacaoResponseDTO;
import com.example.example12.mapper.ContaMapper;
import com.example.example12.model.Conta;
import com.example.example12.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {

    private List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 500.0));
    }

    public TransacaoResponseDTO gerarTransacao(TransacaoRequestDTO requestDTO) {
        Conta origem = findContaByCodigo(requestDTO.origem());
        Conta destino = findContaByCodigo(requestDTO.destino());

        if (origem != null && destino != null && origem.getSaldo() >= requestDTO.valor()) {
            origem.setSaldo(origem.getSaldo() - requestDTO.valor());
            destino.setSaldo(destino.getSaldo() + requestDTO.valor());

            Transacao transacao = new Transacao(origem, destino, requestDTO.valor());
            return new TransacaoResponseDTO(ContaMapper.toDTO(transacao.getOrigem()), ContaMapper.toDTO(transacao.getDestino()), transacao.getValor());
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou conta inválida.");
        }
    }

    private Conta findContaByCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
