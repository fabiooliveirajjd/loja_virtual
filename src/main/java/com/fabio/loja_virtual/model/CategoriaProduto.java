package com.fabio.loja_virtual.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "categoria_produto")
public class CategoriaProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_desc", nullable = false)
    private String nomeDesc;

}
