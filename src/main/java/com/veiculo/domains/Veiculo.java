package com.veiculo.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    private Long id;

    @NotNull @NotBlank
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;

    @NotNull
    private double valorAquisicao;

    @NotNull @NotBlank
    private String nomeProprietario;

    @NotNull @NotBlank
    private String cpfProprietario;

    public Veiculo() {
    }

    public Veiculo(Long id, String descricao, LocalDate dataAquisicao, double valorAquisicao, String nomeProprietario, String cpfProprietario) {
        this.id = id;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.nomeProprietario = nomeProprietario;
        this.cpfProprietario = cpfProprietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Double.compare(valorAquisicao, veiculo.valorAquisicao) == 0 && Objects.equals(id, veiculo.id) && Objects.equals(descricao, veiculo.descricao) && Objects.equals(dataAquisicao, veiculo.dataAquisicao) && Objects.equals(nomeProprietario, veiculo.nomeProprietario) && Objects.equals(cpfProprietario, veiculo.cpfProprietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataAquisicao, valorAquisicao, nomeProprietario, cpfProprietario);
    }
}
