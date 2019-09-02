package br.com.treinamento.model;

import lombok.Data;

@Data
public class ItemPedido {

    private Integer id;

    private Integer qtde_item;

    private Integer pedido_id;

    private Produto produto;

}
