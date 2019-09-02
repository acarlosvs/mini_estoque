package br.com.treinamento.service;

import br.com.treinamento.model.ItemPedido;

import java.util.List;


public interface IItemPedidoService {

    void inserirItens(List<ItemPedido> listaItens, Integer pedidoId);

    void inserir(Integer pedido_id, ItemPedido itemPedido);

}
