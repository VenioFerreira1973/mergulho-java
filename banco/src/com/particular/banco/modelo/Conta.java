package com.particular.banco.modelo;

import java.util.Objects;

public class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    public Conta(){

    }

    public Conta(Pessoa titular, int agencia, int numero) {

        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }


    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){

        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }
        saldo += valor;

    }

    public void sacar(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }

        if(saldo - valor < 0){
            throw new IllegalStateException("Saldo insuficiente.");
        }
        saldo -= valor;

    }

    public void sacar(double valor, double taxa){
        sacar(valor + taxa);
    }


}
