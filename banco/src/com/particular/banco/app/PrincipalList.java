package com.particular.banco.app;

import com.particular.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PrincipalList {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("João da Silva", "213123123131");
        Pessoa pessoa2 = new Pessoa("Maria das Couves", "213123123232");
        Pessoa pessoa3 = new Pessoa("João da Silva", "213123123131");
        System.out.println(pessoa1);
        System.out.println(pessoa2);

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        System.out.println(pessoas.get(0));
        System.out.println(pessoas.get(1));
        System.out.println(pessoas);

        for(int i = 0; i < pessoas.size(); i++){
            System.out.println(pessoas.get(i).getNome());
        }

        for(Pessoa pessoa: pessoas){
            System.out.println(pessoa.getNome());
        }

        boolean existe = pessoas.contains(pessoa3);
        System.out.println("Contem: " + existe);

        System.out.println(pessoas.contains(pessoa1));

        System.out.println("O nome da pessoa 1 é igual a pessoa 3? "
                + pessoas.get(0).getNome().equals(pessoa3.getNome()));

        System.out.println(pessoa1.equals(pessoa3));
    }
}
