package br.com.treinamento.service;

import br.com.treinamento.model.Produto;

import java.util.List;

public interface IProdutoService {

    List<Produto> recuperarProdutos();

    Produto recuperarPorId(Integer id);

    void inserir(Produto produto);

}
