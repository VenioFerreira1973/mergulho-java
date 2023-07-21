package com.particular.banco.app;

import com.particular.banco.modelo.Pessoa;

import java.util.HashSet;
import java.util.Set;

public class PrincipalSet {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("João da Silva", "213123123131");
        Pessoa pessoa2 = new Pessoa("Maria das Couves", "213123123232");
        Pessoa pessoa3 = new Pessoa("João da Silva", "213123123131");
        //System.out.println(pessoa1);
        //System.out.println(pessoa2);

        Set<Pessoa> pessoas = new HashSet<>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        System.out.println(pessoas);


        for(Pessoa pessoa: pessoas){
            System.out.println(pessoa.getNome());
        }

        boolean existe = pessoas.contains(pessoa3);
        System.out.println("Contem1: " + existe);

        System.out.println("Contem2: " + pessoas.contains(pessoa1));


        System.out.println("Igual: " + pessoa1.equals(pessoa3));
    }
}
