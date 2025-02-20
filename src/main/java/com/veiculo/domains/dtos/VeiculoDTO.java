package com.veiculo.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.veiculo.domains.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VeiculoDTO {

    private Long id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();

    @NotNull(message = "O campo Valor da Aquisição não pode ser nulo")
    private double valorAquisicao;

    @NotNull(message = "O campo Nome Do Proprietário não pode ser nulo")
    @NotBlank(message = "O campo Nome Do Proprietário não pode estar vazio")
    private String nomeProprietario;

    @NotNull(message = "O campo CPF Do Proprietário não pode ser nulo")
    @NotBlank(message = "O campo CPF Do Proprietário não pode estar vazio")
    private String cpfProprietario;

    public VeiculoDTO() {}

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpfProprietario = veiculo.getCpfProprietario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public @NotNull(message = "O campo Valor da Aquisição não pode ser nulo") double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull(message = "O campo Valor da Aquisição não pode ser nulo") double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo Nome Do Proprietário não pode ser nulo") @NotBlank(message = "O campo Nome Do Proprietário não pode estar vazio") String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull(message = "O campo Nome Do Proprietário não pode ser nulo") @NotBlank(message = "O campo Nome Do Proprietário não pode estar vazio") String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull(message = "O campo CPF Do Proprietário não pode ser nulo") @NotBlank(message = "O campo CPF Do Proprietário não pode estar vazio") String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(@NotNull(message = "O campo CPF Do Proprietário não pode ser nulo") @NotBlank(message = "O campo CPF Do Proprietário não pode estar vazio") String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }
}
