package com.example.example12.mapper;

import com.example.example12.dto.ContaDTO;
import com.example.example12.model.Conta;

public class ContaMapper {

    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }

    public static Conta toEntity(ContaDTO contaDTO) {
        return new Conta(contaDTO.codigo(), contaDTO.cliente(), 0.0);
    }
}
