package br.com.treinamento.service;

import br.com.treinamento.model.Estoque;
import br.com.treinamento.model.Pedido;

import java.util.List;

public interface IEstoqueService {

    List<Estoque> recuperarEstoqueFilial(Integer filialId);

    Integer recuperarQtdeEmEstoque(Integer produto_id, Integer filial_id);

    void atualizarQuantidadeProduto(Pedido pedido);

}
