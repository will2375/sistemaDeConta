package com.contaBancaria.sistema.model.calculosDaConta;

import java.math.BigDecimal;

public class Deposito implements CalculoConta{
    @Override
    public BigDecimal servicoCalculo(BigDecimal valor, BigDecimal alteracao) {

        BigDecimal calculoDeposito = valor.add(alteracao);
        return calculoDeposito;
    }
}
