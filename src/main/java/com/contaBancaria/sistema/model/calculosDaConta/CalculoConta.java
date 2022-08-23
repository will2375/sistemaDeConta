package com.contaBancaria.sistema.model.calculosDaConta;

import java.math.BigDecimal;

public interface CalculoConta {

    BigDecimal servicoCalculo(BigDecimal valor, BigDecimal alteracao);
}
