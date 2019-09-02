package br.com.treinamento.controller;

import br.com.treinamento.model.Filial;
import br.com.treinamento.service.FilialService;
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
@RequestMapping("/filial")
public class FilialController {

    @Autowired
    FilialService filialService;

    @RequestMapping(method = RequestMethod.GET, value = "/listar")
    public ResponseEntity recuperar() {
        try {
            List<Filial> filials = filialService.recuperarFiliais();

            return ResponseEntity.ok(filials);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/recuperar/{id}")
    public ResponseEntity recuperarPorId(@PathVariable("id") Integer id) {
        try {
            Filial filial = filialService.recuperarPorId(id);

            return ResponseEntity.ok(filial);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inserir")
    public ResponseEntity inserir(@RequestBody Filial filial) {
        try {
            filialService.inserir(filial);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
