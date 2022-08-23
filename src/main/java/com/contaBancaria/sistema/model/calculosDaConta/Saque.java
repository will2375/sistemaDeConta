package com.contaBancaria.sistema.model.calculosDaConta;

import java.math.BigDecimal;

public class Saque implements CalculoConta{
    @Override
    public BigDecimal servicoCalculo(BigDecimal valor, BigDecimal alteracao) {
        BigDecimal calculoSaque = valor.subtract(alteracao);
        return calculoSaque;
    }
}
