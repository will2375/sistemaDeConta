package com.contaBancaria.sistema.model.calculosDaConta;

public class CalculoDaContaFactory {

    public CalculoConta getCalculoSaldo(String statusServico) {
        if(statusServico.equalsIgnoreCase("debito")) {
            return new Deposito();
        }else if(statusServico.equalsIgnoreCase("saque")){
            return new Saque();
        }else {
            return null;
        }
    }
}
