package com.particular.banco.modelo.pagamentos;

import com.particular.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel{

    private Pessoa beneficiario;

    private BigDecimal valor;
    private boolean pago = false;

    public Boleto(Pessoa beneficiario, BigDecimal valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }


    @Override
    public BigDecimal getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void estornarPagamento() {
        this.pago = false;
    }

    @Override
    public void quitarPagamento() {
        this.pago = true;
    }
}
