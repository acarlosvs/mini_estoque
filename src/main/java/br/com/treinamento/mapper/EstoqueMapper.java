package br.com.treinamento.mapper;

import br.com.treinamento.model.Estoque;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EstoqueMapper {

    List<Estoque> recuperarEstoqueFilial(@Param("filialId") Integer filialId);

    Integer recuperarQtdeEmEstoque(@Param("produtoId") Integer produtoId, @Param("filialId") Integer filialId);

    Integer atualizarQuantidadeProduto(@Param("produtoId") Integer produtoId, @Param("filialId") Integer filialId, @Param("qtdeProdutos") Integer qtdeProdutos);

}
