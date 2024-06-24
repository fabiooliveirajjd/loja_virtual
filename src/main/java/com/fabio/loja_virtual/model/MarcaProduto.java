package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "marca_produto")
@SequenceGenerator(name = "seq_marca_produto_novo", sequenceName = "seq_marca_produto_novo", initialValue = 1, allocationSize = 1)
public class MarcaProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto_novo")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_desc", nullable = false)
    private String nomeDesc;

}
