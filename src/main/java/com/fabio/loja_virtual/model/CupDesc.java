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
    private Long id;

    private String codDes;

    private BigDecimal valorRealDesc;

    private BigDecimal valorPorcentDesc;

    @Temporal(TemporalType.DATE)
    private Date dataValidadeCupom;
}
