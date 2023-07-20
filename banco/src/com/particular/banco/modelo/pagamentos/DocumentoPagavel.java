package com.particular.banco.modelo.pagamentos;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo(){
        System.out.println("Recibo:");
        System.out.println("Valor total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }
}
