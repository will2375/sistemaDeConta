package com.contaBancaria.sistema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contas")
public class ContaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long codigo;
    @Column(length = 50, nullable = false)
    private String numeroConta;
    @Column(length = 50, nullable = false)
    private String agencia;
    @Column(length = 50, nullable = false)
    private String nomeUsuario;
    @Column(length = 50, nullable = false)
    private BigDecimal saldo;
    @Column(length = 50, nullable = false)
    private BigDecimal saldoFinal;
    @Column(length = 50, nullable = false)
    private BigDecimal alterarSaldo;
    @Column(length = 50)
    private String servico;
}
