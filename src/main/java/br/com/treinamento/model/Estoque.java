package br.com.treinamento.model;

import lombok.Data;

@Data
public class Estoque {

    private Integer id;

    private Integer qtde_produto;

    private Produto produto;

    private Filial filial;

}
