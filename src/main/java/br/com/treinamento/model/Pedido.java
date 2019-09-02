package br.com.treinamento.model;

import lombok.Data;

import java.util.List;

@Data
public class Pedido {

    private Integer id;

    private Filial filial;

    private List<ItemPedido> listaItens;

}
