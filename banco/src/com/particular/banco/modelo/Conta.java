package com.particular.banco.modelo;

import com.particular.banco.modelo.excecao.SaldoInsuficienteException;
import com.particular.banco.modelo.excecao.ValorMaiorQueZeroException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    public Conta(){

    }

    public Conta(Pessoa titular, int agencia, int numero) {

        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }


    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor){

        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorMaiorQueZeroException("O valor de depósito deve ser maior que zero.");
        }
        saldo = saldo.add(valor);

    }

    public void sacar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorMaiorQueZeroException("Valor de saque deve ser maior que zero.");
        }

        if(getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        saldo = saldo.subtract(valor);

    }

    public void sacar(BigDecimal valor, BigDecimal taxa){
        sacar(valor.add(taxa));
    }

    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }


}
