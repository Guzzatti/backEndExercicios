package org.example;

public class Ingresso {
    private Cliente cliente;
    private Filme filme;
    private String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public String getAssento() {
        return assento;
    }
}
