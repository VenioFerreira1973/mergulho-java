package com.particular.banco.modelo;

import com.particular.banco.modelo.enumeracoes.TipoPessoa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private String documento;
    private BigDecimal rendimentoAnual = BigDecimal.ZERO;

    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

    private TipoPessoa tipo = TipoPessoa.FISICA;

    public Pessoa(){

    }

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BigDecimal getRendimentoAnual() {
        return rendimentoAnual;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(documento, pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
