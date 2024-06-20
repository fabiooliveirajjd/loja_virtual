package com.fabio.loja_virtual.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class PessoFisica extends Pessoa {

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

}
