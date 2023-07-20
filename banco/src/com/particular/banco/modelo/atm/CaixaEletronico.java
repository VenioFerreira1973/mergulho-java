package com.particular.banco.modelo.atm;

import com.particular.banco.modelo.Conta;
import com.particular.banco.modelo.excecao.DocumentoNaoPagoException;
import com.particular.banco.modelo.excecao.DocumentoPagoException;
import com.particular.banco.modelo.pagamentos.DocumentoEstornavel;
import com.particular.banco.modelo.pagamentos.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        System.out.println("Conta: " + conta.getNumero() + " / Agência: " + conta.getAgencia());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta){
        if(documento.estaPago()){
            throw new DocumentoPagoException("Documento já está pago.");
        }

        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();
    }

    public void estornar(DocumentoEstornavel documento, Conta conta){
        if(!documento.estaPago()){
            throw new DocumentoNaoPagoException("Documento não está pago.");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();
    }
}
