package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_unidade", nullable = false)
    private String tipoUnidade;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = Boolean.TRUE;

    @Column(columnDefinition = "TEXT", length = 2000, nullable = false)
    private String descricao;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "largura", nullable = false)
    private Double largura;

    @Column(name = "altura", nullable = false)
    private Double altura;

    @Column(name = "profundidade", nullable = false)
    private Double profundidade;

    @Column(name = "valor_venda", nullable = false)
    private BigDecimal valorVenda = BigDecimal.ZERO;

    @Column(nullable = false)
    private Integer QtdEstoque = 0;

    @Column(nullable = false)
    private Integer QtdeAlertaEstoque = 0;

    private String linkYoutube;

    private Boolean alertaQtdeEstoque = Boolean.FALSE;

    private Integer qtdeClique = 0;

}
