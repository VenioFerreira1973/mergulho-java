package com.particular.banco.modelo.excecao;

public class DocumentoNaoPagoException extends RuntimeException{

    public DocumentoNaoPagoException(String message) {
        super(message);
    }
}
