package br.com.treinamento.controller;


import br.com.treinamento.model.Produto;
import br.com.treinamento.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET, value = "/listar")
    public ResponseEntity recuperarProdutos() {
        try {
            List<Produto> produtos = produtoService.recuperarProdutos();

            return ResponseEntity.ok(produtos);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/recuperar/{id}")
    public ResponseEntity recuperarPorId(@PathVariable("id") Integer id) {
        try {
            Produto produtos = produtoService.recuperarPorId(id);

            return ResponseEntity.ok(produtos);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inserir")
    public ResponseEntity inserir(@RequestBody Produto produto) {
        try {
            produtoService.inserir(produto);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
