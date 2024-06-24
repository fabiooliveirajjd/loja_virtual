package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")
@Data
@EqualsAndHashCode
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

}
