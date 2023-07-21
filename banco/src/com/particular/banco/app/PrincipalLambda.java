package com.particular.banco.app;

import com.particular.banco.impl.NumeroContaFunction;
import com.particular.banco.modelo.Banco;
import com.particular.banco.modelo.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class PrincipalLambda {

    public static void main(String[] args) {
        Banco banco = new Banco();



        //Ordena a lista de bancos pelo numero da conta
        //banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

        //Ordenando com função lambda
        //ToIntFunction<Conta> function = (Conta conta) -> conta.getNumero();
        //banco.getContas().sort(Comparator.comparingInt(function));

        //Função lambda simplificada
        //banco.getContas().sort(Comparator.comparingInt((Conta conta) -> conta.getNumero()));

        //Mais simples ainda
        //banco.getContas().sort(Comparator.comparingInt((Conta conta) -> conta.getNumero()));

        //Mais ainda
        banco.getContas().sort(Comparator.comparingInt(Conta :: getNumero));




        for(Conta conta: banco.getContas()){
            System.out.println(conta.getAgencia() + " / " + conta.getNumero());
        }
    }

}
