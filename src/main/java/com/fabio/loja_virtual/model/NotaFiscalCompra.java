package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "nota_fiscal_compra")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_nota", nullable = false)
    private String numeroNota;

    @Column(name = "serie_nota", nullable = false)
    private String serieNota;

    @Column(name = "descricao_obs")
    private String descricaoObs;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "valor_desconto")
    private BigDecimal valorDesconto;

    @Column(name = "valor_icms")
    private BigDecimal valorIcms;

    @Temporal(TemporalType.DATE)
    private Date dataCompra;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "conta_pagar_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk"))
    private ContaPagar contaPagar;

}
