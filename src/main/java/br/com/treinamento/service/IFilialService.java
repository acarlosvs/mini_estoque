package br.com.treinamento.service;

import br.com.treinamento.model.Filial;

import java.util.List;

public interface IFilialService {

    List<Filial> recuperarFiliais();

    Filial recuperarPorId(Integer id);

    void inserir(Filial filial);

}
