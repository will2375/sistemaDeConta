package com.contaBancaria.sistema.repository;

import com.contaBancaria.sistema.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculoContaRepository extends JpaRepository <ContaModel, Long> {
}
