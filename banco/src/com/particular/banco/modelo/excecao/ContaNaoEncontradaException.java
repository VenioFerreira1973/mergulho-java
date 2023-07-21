package com.particular.banco.modelo.excecao;

public class ContaNaoEncontradaException extends RuntimeException{

    public ContaNaoEncontradaException(String message) {
        super(message);
    }
}
