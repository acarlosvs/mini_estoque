package br.com.treinamento.mapper;

import br.com.treinamento.model.Filial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface FilialMapper {

    List<Filial> recuperarFiliais();

    Filial recuperarPorId(@Param("id") Integer id);

    void inserir(@Param("filial") Filial filial);

}
