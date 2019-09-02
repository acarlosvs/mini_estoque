package br.com.treinamento.controller;

import br.com.treinamento.model.Estoque;
import br.com.treinamento.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @RequestMapping(method = RequestMethod.GET, value = "/recuperar-estoque-filial/{id}")
    public ResponseEntity recuperarEstoqueFilial(@PathVariable("id") Integer filialId) {
        try {
            List<Estoque> estoqueLista = estoqueService.recuperarEstoqueFilial(filialId);

            return ResponseEntity.ok(estoqueLista);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
