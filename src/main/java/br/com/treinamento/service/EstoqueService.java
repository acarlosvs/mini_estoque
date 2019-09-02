package br.com.treinamento.service;

import br.com.treinamento.mapper.EstoqueMapper;
import br.com.treinamento.model.Estoque;
import br.com.treinamento.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService implements IEstoqueService {

    @Autowired
    EstoqueMapper estoqueMapper;

    @Override
    public List<Estoque> recuperarEstoqueFilial(Integer filialId) {
        return estoqueMapper.recuperarEstoqueFilial(filialId);
    }

    @Override
    public Integer recuperarQtdeEmEstoque(Integer produtoId, Integer filialId) {
        return estoqueMapper.recuperarQtdeEmEstoque(produtoId, filialId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void atualizarQuantidadeProduto(Pedido pedido) {
        pedido.getListaItens().forEach(itemPedido -> {
            Integer qtdeEstoque = recuperarQtdeEmEstoque(itemPedido.getProduto().getId(), pedido.getFilial().getId());
            Integer qtdeResultado = qtdeEstoque - itemPedido.getQtde_item();

            estoqueMapper.atualizarQuantidadeProduto(itemPedido.getProduto().getId(), pedido.getFilial().getId(), qtdeResultado);
        });
    }

}
