package com.particular.banco.app;

import com.particular.banco.modelo.atm.CaixaEletronico;
import com.particular.banco.modelo.*;
import com.particular.banco.modelo.enumeracoes.TipoPessoa;
import com.particular.banco.modelo.excecao.DocumentoNaoPagoException;
import com.particular.banco.modelo.excecao.SaldoInsuficienteException;
import com.particular.banco.modelo.excecao.ValorMaiorQueZeroException;
import com.particular.banco.modelo.pagamentos.Boleto;
import com.particular.banco.modelo.pagamentos.DocumentoPagavel;
import com.particular.banco.modelo.pagamentos.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("1232121121122");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);
        System.out.println("Tipo: " + titular1.getTipo());
        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-07-19T12:05:01"));
        System.out.println("Data ultima atualização: " + titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("123212112155543");


        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123,456);
        ContaEspecial suaConta = new ContaEspecial(titular2,123, 789, new BigDecimal("1000"));
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        Boleto boletoEscola = new Boleto(titular1, new BigDecimal("800"));
        DocumentoPagavel salarioFuncionario = new Holerite(titular1, new BigDecimal("100"), 172);

        minhaConta.depositar(new BigDecimal("30000"));
        suaConta.depositar(new BigDecimal("15000"));
        minhaConta.creditarRendimentos(new BigDecimal("0.8"));

        try{

            minhaConta.sacar(new BigDecimal("5000"));
            minhaConta.sacar(new BigDecimal("1000"), new BigDecimal("50"));
            //minhaConta.creditarRendimentos(0.8);
            minhaConta.debitarTarifaMensal();

            suaConta.sacar(new BigDecimal("1500"));
            suaConta.debitarTarifaMensal();

            //System.out.println("Boleto pago: " + boletoEscola.estaPago());
            caixaEletronico.pagar(boletoEscola, minhaConta);
            //System.out.println("Boleto pago: " + boletoEscola.estaPago());

            caixaEletronico.pagar(salarioFuncionario, minhaConta);
            //System.out.println("Salário pago: " + salarioFuncionario.estaPago());

        }catch (SaldoInsuficienteException | ValorMaiorQueZeroException | DocumentoNaoPagoException e){
            System.out.println("Erro ao executar operação na conta - " + e.getMessage());
        }


        caixaEletronico.estornar(boletoEscola, minhaConta);

        System.out.println("-------------------------------------------------");
        boletoEscola.imprimirRecibo();
        System.out.println();
        salarioFuncionario.imprimirRecibo();
        System.out.println("-------------------------------------------------");
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
        System.out.println("-------------------------------------------------");

    }
}
