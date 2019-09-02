package br.com.treinamento.mapper;

import br.com.treinamento.model.ItemPedido;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ItemPedidoMapper {

    void inserirItens(@Param("itensPedido") List<ItemPedido> itensPedido);

    void inserir(@Param("pedido_id") Integer pedido_id, @Param("itemPedido") ItemPedido itemPedido);

}
