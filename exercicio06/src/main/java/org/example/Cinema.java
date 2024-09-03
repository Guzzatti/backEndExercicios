package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;

    public Cinema() {
        this.filmesDisponiveis = new ArrayList<>();
        this.ingressosVendidos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nome) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public boolean assentoDisponivel(String assento) {
        for (Ingresso ingresso : ingressosVendidos) {
            if (ingresso.getAssento().equalsIgnoreCase(assento)) {
                return false;
            }
        }
        return true;
    }

    public void venderIngresso(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
        System.out.println("Ingresso vendido com sucesso! " + ingresso.getFilme().getNome() + " - " + ingresso.getAssento() + " - " + ingresso.getCliente().getNome());
    }
}
