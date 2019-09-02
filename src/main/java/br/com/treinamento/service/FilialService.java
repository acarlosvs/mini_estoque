package br.com.treinamento.service;

import br.com.treinamento.mapper.FilialMapper;
import br.com.treinamento.model.Filial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialService implements IFilialService {

    @Autowired
    FilialMapper filialMapper;

    @Override
    public List<Filial> recuperarFiliais() {
        List<Filial> filials = filialMapper.recuperarFiliais();

        return filials;
    }

    @Override
    public Filial recuperarPorId(Integer id) {
        Filial filial = filialMapper.recuperarPorId(id);

        return filial;
    }

    @Override
    public void inserir(Filial filial) {
        filialMapper.inserir(filial);

        if (filial.getId() == null) {
            throw  new RuntimeException("Erro ao inserir filial!");
        }

    }
}
