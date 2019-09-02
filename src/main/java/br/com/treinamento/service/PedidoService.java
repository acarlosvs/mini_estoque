package br.com.treinamento.service;

import br.com.treinamento.mapper.PedidoMapper;
import br.com.treinamento.model.ItemPedido;
import br.com.treinamento.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    PedidoMapper pedidoMapper;

    @Autowired
    EstoqueService estoqueService;

    @Autowired
    ItemPedidoService itemPedidoService;

    @Override
    public Pedido recuperarPedidoPorId(Integer pedidoId) {
        Pedido pedido = pedidoMapper.recuperarPedidoPorId(pedidoId);

        return pedido;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void criarPedido(Pedido pedido) {
        List<ItemPedido> listaItens = pedido.getListaItens();
        listaItens.forEach(itemPedido -> {
            Integer qtdeDisponivel = estoqueService.recuperarQtdeEmEstoque(itemPedido.getProduto().getId(), pedido.getFilial().getId());
            if (qtdeDisponivel < itemPedido.getQtde_item()) {
                throw  new RuntimeException("O estoque não contém a quantidade de itens do produto " + itemPedido.getProduto().getDescricao());
            }
        });

        pedidoMapper.criarPedido(pedido);

        if (pedido.getId() == null) {
            throw  new RuntimeException("Erro ao criar pedido!");
        } else {
            itemPedidoService.inserirItens(listaItens, pedido.getId());

            estoqueService.atualizarQuantidadeProduto(pedido);
        }

    }

}
