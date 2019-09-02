package br.com.treinamento.controller;

import br.com.treinamento.model.Pedido;
import br.com.treinamento.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.GET, value = "/recuperar/{pedidoId}")
    public ResponseEntity recuperarPorId(@PathVariable("pedidoId") Integer pedidoId) {
        try {
            Pedido pedido = pedidoService.recuperarPedidoPorId(pedidoId);

            return ResponseEntity.ok(pedido);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inserir")
    public ResponseEntity criarPedido(@RequestBody Pedido pedido) {
        try {
            pedidoService.criarPedido(pedido);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
