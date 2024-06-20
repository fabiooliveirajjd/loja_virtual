package com.fabio.loja_virtual.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class PessaJuridica extends Pessoa {

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "inscricao_estadual", nullable = false)
    private String inscricaoEstadual;

    @Column(name = "inscricao_municipal", nullable = false)
    private String inscricaoMunicipal;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "categoria", nullable = false)
    private String categoria;

}
