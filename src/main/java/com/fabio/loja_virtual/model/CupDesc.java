package com.fabio.loja_virtual.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cup_desc")
@Data
@EqualsAndHashCode
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupDesc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
    @Column(name = "id")
    private Long id;

    @Column(name = "cod_des", nullable = false)
    private String codDes;

    @Column(name = "valor_real_desc")
    private BigDecimal valorRealDesc;

    @Column(name = "valor_porcent_desc")
    private BigDecimal valorPorcentDesc;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_validade_cupom", nullable = false)
    private Date dataValidadeCupom;

}
