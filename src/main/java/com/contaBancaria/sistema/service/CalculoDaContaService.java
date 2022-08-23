package com.contaBancaria.sistema.service;

import com.contaBancaria.sistema.model.ContaModel;
import com.contaBancaria.sistema.model.calculosDaConta.CalculoDaContaFactory;
import com.contaBancaria.sistema.repository.CalculoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CalculoDaContaService {

    @Autowired
    private CalculoContaRepository calculoContaRepository;

    public List<ContaModel> buscarcontas(){return calculoContaRepository.findAll();}

    public Optional<ContaModel>buscarId(Long codigo){return calculoContaRepository.findById(codigo);}

    public ContaModel cadastrorConta(ContaModel contaModel){
        contaModel.getCodigo();
        contaModel.getNumeroConta();
        contaModel.getAgencia();
        contaModel.getNomeUsuario();
        contaModel.getSaldo();
        contaModel.getAlterarSaldo();
        contaModel.getSaldoFinal();
        return calculoContaRepository.save(contaModel);
    }

    public ContaModel  calcularSaldo(ContaModel contaModel, CalculoDaContaFactory calculoDaContaFactory){
        BigDecimal resultado= calculoDaContaFactory.getCalculoSaldo(contaModel.getServico()).servicoCalculo(contaModel.getSaldo(), contaModel.getAlterarSaldo());
        contaModel.getCodigo();
        contaModel.getNumeroConta();
        contaModel.getAgencia();
        contaModel.getNomeUsuario();
        contaModel.getServico();
        contaModel.getAlterarSaldo();
        contaModel.getSaldo();
        contaModel.setSaldoFinal(resultado);
        return calculoContaRepository.save(contaModel);
    }

    public void deletar(Long codigo) {calculoContaRepository.deleteById(codigo);}

}
