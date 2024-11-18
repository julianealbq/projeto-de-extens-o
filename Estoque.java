package com.exemplo.controlevendas;

import java.util.HashMap;

public class Estoque {
    private HashMap<String, Integer> estoque;

    public Estoque() {
        estoque = new HashMap<>();
    }

    public boolean adicionarProduto(String produto, int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        int quantidadeAtual = estoque.getOrDefault(produto, 0);
        estoque.put(produto, quantidadeAtual + quantidade);
        return true;
    }

    public boolean removerProduto(String produto, int quantidade) {
        if (!estoque.containsKey(produto) || estoque.get(produto) < quantidade) {
            return false;
        }
        int quantidadeAtual = estoque.get(produto);
        estoque.put(produto, quantidadeAtual - quantidade);
        return true;
    }

    public int verificarEstoque(String produto) {
        return estoque.getOrDefault(produto, 0);
    }
}
