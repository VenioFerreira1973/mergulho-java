package com.particular.banco.modelo.pagamentos;

import com.particular.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Holerite implements DocumentoPagavel{

    private final Pessoa funcionario;
    private final BigDecimal valorHora;
    private final int quantidadeHoras;
    private boolean pago;


    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
    }


    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(BigDecimal.valueOf(quantidadeHoras));
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }
}
