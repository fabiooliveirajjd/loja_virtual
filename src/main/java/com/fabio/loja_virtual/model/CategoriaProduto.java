package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria_produto")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", initialValue = 1, allocationSize = 1)
public class CategoriaProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_desc", nullable = false)
    private String nomeDesc;

}
