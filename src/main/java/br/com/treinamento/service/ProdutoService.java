package br.com.treinamento.service;

import br.com.treinamento.mapper.ProdutoMapper;
import br.com.treinamento.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    ProdutoMapper produtoMapper;

    @Override
    public List<Produto> recuperarProdutos() {
        List<Produto> produtos = produtoMapper.recuperarProdutos();

        return produtos;
    }

    @Override
    public Produto recuperarPorId(Integer id) {
        Produto produto = produtoMapper.recuperarPorId(id);

        return produto;
    }

    @Override
    public void inserir(Produto produto) {
        produtoMapper.inserir(produto);

        if (produto.getId() == null) {
            throw  new RuntimeException("Erro ao inserir produto!");
        }

    }
}
