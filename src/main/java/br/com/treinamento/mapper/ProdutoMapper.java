package br.com.treinamento.mapper;

import br.com.treinamento.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ProdutoMapper {

    List<Produto> recuperarProdutos();

    Produto recuperarPorId(@Param("id") Integer id);

    void inserir(@Param("produto") Produto produto);

}
