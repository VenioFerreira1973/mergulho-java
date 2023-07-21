package com.particular.banco.app;

import com.particular.banco.modelo.Banco;
import com.particular.banco.modelo.Conta;
import com.particular.banco.modelo.excecao.ContaNaoEncontradaException;

import java.math.BigDecimal;
import java.util.Optional;

public class PrincipalOptional {

    public static void main(String[] args) {
        Banco banco = new Banco();

        //Optional<Conta> contaEncontrada = banco.buscarConta(123, 2222);
        banco.buscarConta(123, 222)
                .ifPresent(conta -> System.out.println(conta.getSaldo()));

        System.out.println("----------------------------------");

        Conta contaEncontrada = banco.buscarConta(123,222)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada"));

        System.out.println(contaEncontrada.getSaldo());

        System.out.println("----------------------------------");


        BigDecimal saldo = banco.buscarConta(123, 2022)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);
        System.out.println(saldo);

    }
}
