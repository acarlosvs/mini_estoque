package br.com.treinamento.mapper;

import br.com.treinamento.model.Pedido;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PedidoMapper {

    Pedido recuperarPedidoPorId(@Param("pedidoId") Integer pedidoId);

    void criarPedido(@Param("pedido") Pedido pedido);

}
