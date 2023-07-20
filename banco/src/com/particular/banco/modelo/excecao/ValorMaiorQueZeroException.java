package com.particular.banco.modelo.excecao;

public class ValorMaiorQueZeroException extends RuntimeException{

    public ValorMaiorQueZeroException(String message) {
        super(message);
    }
}
