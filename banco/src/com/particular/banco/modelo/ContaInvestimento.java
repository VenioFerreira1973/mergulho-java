package com.particular.banco.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero);
    }

    @Override
    public void debitarTarifaMensal() {
        if(getSaldo().compareTo(new BigDecimal("10000")) < 0){
            sacar(new BigDecimal(30));
        }

    }


    public void creditarRendimentos(BigDecimal percentualJuros){
        /*o resultado do calculo abaixo é arredondado para um tipo de arredondamento
         bancário com duas casas decimais */
        BigDecimal valorRendimentos = getSaldo().multiply(percentualJuros)
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
        depositar(valorRendimentos);
    }
}
