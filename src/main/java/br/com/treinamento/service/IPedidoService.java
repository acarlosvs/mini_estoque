package br.com.treinamento.service;

import br.com.treinamento.model.Pedido;

public interface IPedidoService {

    Pedido recuperarPedidoPorId(Integer pedidoId);

    void criarPedido(Pedido pedido);

}
