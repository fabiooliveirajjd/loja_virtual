package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status_rastreio")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_status_rastreio", sequenceName = "seq_status_rastreio", allocationSize = 1, initialValue = 1)
public class StatusRastreio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_rastreio")
    @Column(name = "id")
    private Long id;

    @Column(name = "centro_distribuicao")
    private String centroDistribuicao;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "venda_compra_loja_virt_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virt_fk"))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

}
