package com.example.example12.model;

public class Transacao {
    private Conta origem;
    private Conta destino;
    private Double valor;

    public Transacao(Conta origem, Conta destino, Double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public Conta getOrigem() {
        return origem;
    }

    public void setOrigem(Conta origem) {
        this.origem = origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
