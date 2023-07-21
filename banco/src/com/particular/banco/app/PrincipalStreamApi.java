package com.particular.banco.app;

import com.particular.banco.modelo.Banco;
import com.particular.banco.modelo.Conta;
import com.particular.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class PrincipalStreamApi {

    public static void main(String[] args) {
        Banco banco = new Banco();

    /*    Stream<Conta> stream = banco.getContas().stream();
        Stream<Conta> stream2 = stream.filter(
                conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0);
        Stream<Conta> stream3 = stream2.filter(conta -> conta.getNumero() > 300);

        stream3.forEach(conta -> {
            BigDecimal saldoAnterior = conta.getSaldo();
            conta.depositar(new BigDecimal("10"));
            System.out.println(conta.getAgencia() + " / " + conta.getNumero()
                + " = " + saldoAnterior + "-> " + conta.getSaldo());
        });
*/
        //abaixo o codigo simplificado com o encadeamento direto das operações no pipline stream
        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumero() > 200)
                .forEach(conta -> {
                    BigDecimal saldoAnterior = conta.getSaldo();
                    conta.depositar(new BigDecimal("10"));
                    System.out.println(conta.getAgencia() + " / " + conta.getNumero()
                        + " = " + saldoAnterior + "-> " + conta.getSaldo());
                });

        System.out.println("------------------------");

        //As mesmas contas porém com ordenação
        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumero() > 200)
                .sorted(Comparator.comparingInt(Conta::getNumero))
                .forEach(conta -> {
                    System.out.println(conta.getAgencia() + " / " + conta.getNumero()
                            + "-> " + conta.getSaldo());
                });


        //Imprimindo o titular através da conta
        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumero() > 200)
                .map(Conta::getTitular)
                .distinct()
                .forEach(titular -> {
                    System.out.println("Nome: " + titular.getNome());
                });


        //Imprimir a soma total dos saldos pelas contas
        BigDecimal totalSaldos = banco.getContas().stream()
                                .map(Conta::getSaldo)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalSaldos);

        //Imprimindo uma lista de pessoas pelas contas
        List<Pessoa> pessoas = banco.getContas()
                .stream()
                .map(Conta::getTitular)
                .distinct()
                .toList();
                //.collect(Collectors.toList()); produz o mesmo resultado da linha acima

        System.out.println(pessoas);

        //Imprimir somente o nome das pessoas
        pessoas.stream()
                .forEach(pessoa -> System.out.println("Nome: " + pessoa.getNome()));

    }
}
