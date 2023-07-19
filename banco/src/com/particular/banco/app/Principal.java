package com.particular.banco.app;

import com.particular.banco.modelo.Conta;
import com.particular.banco.modelo.Pessoa;

public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("1232121121122");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("123212112155543");


        Conta minhaConta = new Conta(titular1, 123,456);
        minhaConta.depositar(15000);
        minhaConta.sacar(1000);
        minhaConta.sacar(1000, 50);

        Conta suaConta = new Conta(titular2,123, 789);
        //suaConta.saldo = 30000;
        suaConta.depositar(30000);

        System.out.println("Nome titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Nome titular: " + suaConta.getTitular().getNome());
        System.out.println("Saldo: " + suaConta.getSaldo());
    }
}
