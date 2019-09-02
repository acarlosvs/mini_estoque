package br.com.treinamento.service;

import br.com.treinamento.mapper.ItemPedidoMapper;
import br.com.treinamento.model.ItemPedido;
import br.com.treinamento.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ItemPedidoService implements IItemPedidoService {

    @Autowired
    ItemPedidoMapper itemPedidoMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void inserirItens(List<ItemPedido> listaItens, Integer pedidoId) {
        listaItens.forEach(itemPedido -> {
            itemPedido.setPedido_id(pedidoId);
        });

        itemPedidoMapper.inserirItens(listaItens);

        listaItens.forEach(itemPedido -> {
            if (itemPedido.getId() == null) {
                throw  new RuntimeException("Erro ao inserir item " + itemPedido.getProduto());
            }
        });

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void inserir(Integer pedido_id, ItemPedido itemPedido) {
        itemPedidoMapper.inserir(pedido_id, itemPedido);

            if (itemPedido.getId() == null) {
                throw  new RuntimeException("Erro ao inserir item!");
            }

    }
}
