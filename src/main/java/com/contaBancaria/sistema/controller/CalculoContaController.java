package com.contaBancaria.sistema.controller;

import com.contaBancaria.sistema.model.ContaModel;
import com.contaBancaria.sistema.model.calculosDaConta.CalculoDaContaFactory;
import com.contaBancaria.sistema.service.CalculoDaContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CalculoContaController {

    @Autowired
    private CalculoDaContaService calculoDaContaService;

    @GetMapping(path = "/contas")
    public ResponseEntity< List<ContaModel>> buscarContas() {return ResponseEntity.ok(calculoDaContaService.buscarcontas());}

    @GetMapping(path = "/contas/{codigo}")
    public ResponseEntity<Optional<ContaModel>> buscarPorId(@PathVariable  Long codigo) {
        return ResponseEntity.ok(calculoDaContaService.buscarId(codigo));
    }

    @PostMapping(path = "/contas")
    public  ResponseEntity<ContaModel> cadastrarContas(@RequestBody ContaModel contaModel){
        ContaModel contas= calculoDaContaService.cadastrorConta(contaModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @PutMapping("/contas/{codigo}")
    public ResponseEntity<ContaModel> calculoDeSaldo(@RequestBody ContaModel contaModel, CalculoDaContaFactory calculoDaContaFactory){
        return ResponseEntity.ok(calculoDaContaService.calcularSaldo(contaModel, calculoDaContaFactory));
    }

    @DeleteMapping(path = "contas/{codigo}")
    public void deletarconta(@PathVariable Long codigo) {
        calculoDaContaService.deletar(codigo);
    }

}
